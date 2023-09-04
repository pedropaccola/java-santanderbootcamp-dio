package com.desafiopoo.models;

public class DefaultInternetBrowser extends Browser {
    @Override
    public void showPage() {
        System.out.println("Showing page");
    }

    @Override
    public void refreshPage() {
        System.out.println("Refreshing page");
    }

    public void newTab() {
        System.out.println("Adding a new tab");
    }

}
