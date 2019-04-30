package com.example.testingfundamentals;

public class Presenter implements Contract.Listener {

    private final Contract.Listener mListener;

    Presenter(Contract.Listener listener) {
        mListener = listener;
    }

    @Override
    public void addNewItem() {
        mListener.addNewItem();
    }
}
