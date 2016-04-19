package com.devintent.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary(calculatePrice()));
    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create a string that summarizes the order
     * @param orderPrice price of order
     * @return summary
     */
    private String createOrderSummary(int orderPrice) {
        return "Name: Kaptain Kunal\nQuantity: " + quantity +
                "\nTotal: $" +  orderPrice +
                "\nThank you!";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if (quantityTextView != null) {
            quantityTextView.setText(String.format("%s%d", getString(R.string.empty_string), number));
        }
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (priceTextView != null) {
            priceTextView.setText(message);
        }
    }
}
