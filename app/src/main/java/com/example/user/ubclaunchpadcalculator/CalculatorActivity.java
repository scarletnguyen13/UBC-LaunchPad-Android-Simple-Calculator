package com.example.user.ubclaunchpadcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity  {

    private String result; //String that will appears on the textView
    private boolean operationAvailable; //indicates whether the user can use operations or not
    private boolean dotAvailable; //indicates whether the user can use the decimal point
    private boolean signAvailable; //indicates whether the user can use the negative sign
    private boolean secondOperation; //becomes true if the user decided to keep using the "Ans"
    private double memory; //stores "Ans" value

    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        switch (v.getId()) {
            case R.id.button0:
                if (secondOperation == false) {
                    result += "0";
                }
                operationAvailable = true;
                break;
            case R.id.button1:
                if (secondOperation == false) {
                    result += "1";
                }
                operationAvailable = true;
                break;
            case R.id.button2:
                if (secondOperation == false) {
                    result += "2";
                }
                operationAvailable = true;
                break;
            case R.id.button3:
                if (secondOperation == false) {
                    result += "3";
                }
                operationAvailable = true;
                break;
            case R.id.button4:
                if (secondOperation == false) {
                    result += "4";
                }
                operationAvailable = true;
                break;
            case R.id.button5:
                if (secondOperation == false) {
                    result += "5";
                }
                operationAvailable = true;
                break;
            case R.id.button6:
                if (secondOperation == false) {
                    result += "6";
                }
                operationAvailable = true;
                break;
            case R.id.button7:
                if (secondOperation == false) {
                    result += "7";
                }
                operationAvailable = true;
                break;
            case R.id.button8:
                if (secondOperation == false) {
                    result += "8";
                }
                operationAvailable = true;
                break;
            case R.id.button9:
                if (secondOperation == false) {
                    result += "9";
                }
                operationAvailable = true;
                break;
            case R.id.buttonAdd:
                if (operationAvailable) {
                    result += " + ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " + ";
                }
                break;
            case R.id.buttonSubtract:
                if (operationAvailable) {
                    result += " – ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " – ";
                }
                break;
            case R.id.buttonMultiply:
                if (operationAvailable) {
                    result += " × ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " × ";
                }
                break;
            case R.id.buttonDivide:
                if (operationAvailable) {
                    result += " ÷ ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " ÷ ";
                }
                break;
            case R.id.buttonModule:
                if (operationAvailable) {
                    result += " % ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " % ";
                }
                break;
            case R.id.buttonExponent:
                if (operationAvailable) {
                    result += " ^ ";
                    operationAvailable = false;
                    dotAvailable = true;
                    signAvailable = true;
                    secondOperation = false;
                } else if (result.isEmpty() != true && operationAvailable == false) {
                    result = result.substring(0,result.length()-3) + " ^ ";
                }
                break;
            case R.id.buttonDot:
                if (dotAvailable && secondOperation == false) {
                    result += ".";
                    dotAvailable = false;
                }
                break;
            case R.id.buttonSigns:
                if (operationAvailable == false && signAvailable) {
                    result += "-";
                    signAvailable = false;
                }
                break;
            case R.id.buttonClear:
                result = "";
                operationAvailable = false;
                dotAvailable = true;
                signAvailable = true;

                secondOperation = false;
                memory = 0.0;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
        textView.setText(result);
    }

    public void equals(View view) {
        boolean divideZero = false;
        TextView textView = (TextView) findViewById(R.id.textView);
        if (result.length() <= 2) {
            Toast.makeText(CalculatorActivity.this, "Incomplete format.", Toast.LENGTH_SHORT).show();
        } else {
            String[] pieces = result.split(" ");
            if (       result.charAt(result.length()-2) == '+'
                    || result.charAt(result.length()-2) == '–'
                    || result.charAt(result.length()-2) == '×'
                    || result.charAt(result.length()-2) == '÷'
                    || result.charAt(result.length()-2) == '%'
                    || result.charAt(result.length()-2) == '^') {
                Toast.makeText(CalculatorActivity.this, "Invalid format used.", Toast.LENGTH_SHORT).show();
            }

            if (pieces.length == 1 && pieces[0].equals("Ans")) {
                textView.setText(memory + "");
            }

            //Calculate the equation that has only 2 operands
            if (pieces.length < 3) {
                Toast.makeText(CalculatorActivity.this, "Incomplete format.", Toast.LENGTH_SHORT).show();
            } else if (pieces.length == 3) {
                double a;
                if (pieces[0].equals("Ans")) {
                    a = memory;
                } else {
                    a = Double.parseDouble(pieces[0]);
                }
                double b = Double.parseDouble(pieces[2]);
                double finalResult = 0.0;
                if (pieces[1].equals("+")) {
                    finalResult = a + b;
                } else if (pieces[1].equals("–")) {
                    finalResult = a - b;
                } else if (pieces[1].equals("×")) {
                    finalResult = a * b;
                } else if (pieces[1].equals("÷")) {
                    if (pieces[2].equals("0")) {
                        Toast.makeText(CalculatorActivity.this, "Cannot divide by zero.", Toast.LENGTH_SHORT).show();
                        divideZero = true;
                    } else {
                        finalResult = a / b;
                    }
                } else if (pieces[1].equals("%")){
                    finalResult = a % b;
                } else {
                    finalResult = Math.pow(a,b);
                }

                if (divideZero) {
                    textView.setText("");
                    memory = 0.0;
                    result = "";
                    operationAvailable = false;
                    secondOperation = false;
                } else {
                    //Remove all of the trailing zeros (if needed)
                    String resultText = finalResult + "";
                    textView.setText(resultText.indexOf(".") < 0 ? resultText : resultText.replaceAll("0*$", "").replaceAll("\\.$", ""));
                    memory = finalResult;
                    result = "Ans";
                    secondOperation = true;
                    operationAvailable = true;
                }
                dotAvailable = true;
                signAvailable = true;
            } else {
                Toast.makeText(CalculatorActivity.this, "2 Operands only.", Toast.LENGTH_SHORT).show();
                result = "";
                operationAvailable = false;
                dotAvailable = true;
                signAvailable = true;
                secondOperation = false;
                memory = 0.0;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result = "";
        operationAvailable = false;
        dotAvailable = true;
        signAvailable = true;
        secondOperation = false;
        memory = 0.0;
    }
}