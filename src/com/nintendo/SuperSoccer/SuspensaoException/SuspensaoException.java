package com.nintendo.SuperSoccer.SuspensaoException;

public class SuspensaoException extends RuntimeException{
    public SuspensaoException() {
        super("\u001B[31mJogador suspenso! Não pode jogar.\u001B[m");
    }
}
