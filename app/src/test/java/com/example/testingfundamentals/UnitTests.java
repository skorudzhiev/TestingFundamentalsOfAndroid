package com.example.testingfundamentals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class UnitTests {

    private Presenter mPresenter;

    @Mock
    private Contract.Listener mListener;

    @Before
    public void setupPresenter() {
        MockitoAnnotations.initMocks(this);

        mPresenter = new Presenter(mListener);
    }

    @Test
    public void clickOnButton_Add_new_item() {
        mPresenter.addNewItem();

        verify(mListener).addNewItem();
    }


}
