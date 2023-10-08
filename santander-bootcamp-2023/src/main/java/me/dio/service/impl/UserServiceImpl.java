package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {
    private static final Long UNCHANGEABLE_USER_ID = 1L;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d must not be %s".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User user) {
        ofNullable(user).orElseThrow(() -> new BusinessException("user must not be null"));
        ofNullable(user.getAccount()).orElseThrow(() -> new BusinessException("user account must not be null"));
        ofNullable(user.getCard()).orElseThrow(() -> new BusinessException("user card must not be null"));

        this.validateChangeableId(user.getId(), "created");
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new BusinessException("this account number already exists");
        }
        if (userRepository.existsByAccountNumber(user.getCard().getNumber())) {
            throw new BusinessException("this card number already exists");
        }
        return this.userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        this.validateChangeableId(id, "updated");
        User dbUser = this.findById(id);
        if (!dbUser.getId().equals(user.getId())) {
            throw new BusinessException("wrong id");
        }
        dbUser.setName(user.getName());
        dbUser.setCard(user.getCard());
        dbUser.setAccount(user.getAccount());
        dbUser.setNews(user.getNews());
        dbUser.setFeatures(user.getFeatures());

        return this.userRepository.save(dbUser);
    }
    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }
}
