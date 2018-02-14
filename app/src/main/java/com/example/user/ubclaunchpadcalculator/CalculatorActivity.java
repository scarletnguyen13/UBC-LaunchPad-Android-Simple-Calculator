package com.example.user.ubclaunchpadcalculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CalculatorActivity extends AppCompatActivity  {

    private static final String TAG = "CalculatorActivity";
    private static final String KEY_TEXTVIEW = "text_view";
    private static final String KEY_OPERATION = "operation_available";
    private static final String KEY_DOT = "dot_available";
    private static final String KEY_SIGN = "sign_available";
    private static final String KEY_SECOND_OPERATION = "second_operation";
    private static final String KEY_MEMORY = "memory";

    private String result; //String that will appears on the textView
    private boolean operationAvailable; //indicates whether the user can use operations or not
    private boolean dotAvailable; //indicates whether the user can use the decimal point
    private boolean signAvailable; //indicates whether the user can use the negative sign
    private boolean secondOperation; //becomes true if the user decided to keep using the "Ans"
    private double memory; //stores "Ans" value

    private TextView textView;

    public void onClick(View v) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                } else if (result.length() >= 3 && operationAvailable == false) {
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
                if (operationAvailable == false && signAvailable && dotAvailable) {
                    result += "-";
                    signAvailable = false;
                }
                break;
            case R.id.buttonClear:
                reset();
                break;

            //NEW FUNCTIONS
            case R.id.buttonSIN:
                if (signAvailable && operationAvailable == false) {
                    result += "sin(";
                }
                break;
            case R.id.buttonCOS:
                if (signAvailable && operationAvailable == false) {
                    result += "cos(";
                }
                break;
            case R.id.buttonTAN:
                if (signAvailable && operationAvailable == false) {
                    result += "tan(";
                }
                break;
            case R.id.buttonFactorial:
                result += "!";
                break;
            case R.id.buttonSquareRoot:
                result += "√";
                break;
            case R.id.buttonPI:
                result += "π";
                break;
            case R.id.buttonOneDivideX:

                break;
            case R.id.buttonXDivide100:

                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
        textView.setText(result);
    }

    public void converter(View view) {
        if (!result.isEmpty() && !result.contains("+") && !result.contains("–") && !result.contains("×") && !result.contains("÷") && !result.contains("%") && !result.contains("^")
                && !result.contains("sin") && !result.contains("cos") && !result.contains("tan")) {
            int a = (int) Double.parseDouble(result);
            if (a > 0) {
                switch (view.getId()) {
                    case R.id.buttonHex:
                        textView.setText(getHexNumber(a));
                        break;
                    case R.id.buttonBi:
                        textView.setText(getBinaryNumber(a));
                        break;
                }
            }
            reset();
        }
    }

    private String getBinaryNumber(int number) {
        String answer = "";
        if (number == 1) {
            return "1";
        } else {
            answer += number % 2 == 1 ? "1" : "0";
            return getBinaryNumber((int) number / 2) + answer;
        }
    }

    private String getHexNumber(int number) {
        String answer = "";
        Map<Integer,String> hex = new TreeMap<Integer, String>();
        hex.put(10,"A"); hex.put(11,"B"); hex.put(12,"C");
        hex.put(13,"D"); hex.put(14,"E"); hex.put(15,"F");
        if (number == 0) {
            return "";
        } else {
            int a = number % 16;
            answer += a >= 10 ? hex.get(a) : a;
            return getHexNumber(number / 16) + answer;
        }
    }

    //TODO: ADD SIN, COS AND TAN FUNCTIONS
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
                    //prevents from having zero(s) in the division
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
                    result = resultText.indexOf(".") < 0 ? resultText : resultText.replaceAll("0*$", "").replaceAll("\\.$", "");
                    secondOperation = true;
                    operationAvailable = true;
                }
                dotAvailable = true;
                signAvailable = true;
            } else {
                Toast.makeText(CalculatorActivity.this, "2 Operands only.", Toast.LENGTH_SHORT).show();
                reset();
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putString(KEY_TEXTVIEW, result);
        savedInstanceState.putBoolean(KEY_OPERATION, operationAvailable);
        savedInstanceState.putBoolean(KEY_DOT, dotAvailable);
        savedInstanceState.putBoolean(KEY_SIGN, signAvailable);
        savedInstanceState.putBoolean(KEY_SECOND_OPERATION, secondOperation);
        savedInstanceState.putDouble(KEY_MEMORY, memory);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView = (TextView) findViewById(R.id.textView);
        reset();
        if (savedInstanceState != null) {
            result = savedInstanceState.getString(KEY_TEXTVIEW, "");
            operationAvailable = savedInstanceState.getBoolean(KEY_OPERATION, false);
            dotAvailable = savedInstanceState.getBoolean(KEY_DOT, false);
            signAvailable = savedInstanceState.getBoolean(KEY_SIGN, false);
            secondOperation = savedInstanceState.getBoolean(KEY_SECOND_OPERATION, false);
            memory = savedInstanceState.getDouble(KEY_MEMORY, 0.0);
            textView.setText(result);
        }
    }

    private void reset() {
        result = "";
        operationAvailable = false;
        dotAvailable = true;
        signAvailable = true;
        secondOperation = false;
        memory = 0.0;
    }
}