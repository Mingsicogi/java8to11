package org.example;

public class NaverLoginServiceImpl implements LoginService {

    @Override
    public String doLogin(String username) {

        //TODO service logic...


        return "### Naver Login Success : " + username;
    }
}
