package com.example.cookieshop.models;

import java.util.List;

public class Basket {
    private List<Cookie> cookieList;

    public Basket(List<Cookie> cookieList) {
        this.cookieList = cookieList;
    }
    public void addCookie(Cookie cookie) {
        cookieList.add(cookie);
    }

    public List<Cookie> getCookieList() {
        return cookieList;
    }

    public void setCookieList(List<Cookie> cookieList) {
        this.cookieList = cookieList;
    }
}