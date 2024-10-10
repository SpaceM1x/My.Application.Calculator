package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private double firstOperand = 0;
    private String currentOperation = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    // Обработка нажатий на кнопки с числами
    public void onNumberClick(View view) {
        Button button = (Button) view;
        if (isNewOperation) {
            display.setText("");  // Очистка поля для нового ввода
            isNewOperation = false;
        }
        display.append(button.getText());  // Добавление цифры к текущему вводу
    }

    // Обработка нажатий на кнопки с операциями
    public void onOperationClick(View view) {
        Button button = (Button) view;
        currentOperation = button.getText().toString();  // Сохранение выбранной операции
        firstOperand = Double.parseDouble(display.getText().toString());  // Сохранение первого операнда
        display.setText("");  // Очистка поля ввода для второго операнда
    }

    // Обработка нажатия на кнопку "равно"
    public void onEqualsClick(View view) {
        double secondOperand = Double.parseDouble(display.getText().toString());
        double result = 0;

        // Выполнение выбранной операции
        switch (currentOperation) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }

        // Отображение результата и подготовка для новой операции
        display.setText(String.valueOf(result));
        isNewOperation = true;
    }

    // Обработка нажатия на кнопку с точкой (десятичная часть)
    public void onDecimalClick(View view) {
        if (!display.getText().toString().contains(".")) {
            display.append(".");  // Добавление десятичного разделителя
        }
    }
}