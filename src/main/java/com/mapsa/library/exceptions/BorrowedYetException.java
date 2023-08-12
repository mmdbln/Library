package com.mapsa.library.exceptions;

public class BorrowedYetException extends Exception{
    public BorrowedYetException() {
        super("The book is borrowed already");
    }
}
