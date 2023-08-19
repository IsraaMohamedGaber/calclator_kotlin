package com.example.calclator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var button_cclear:Button
    private lateinit var button_bbreaket_left:Button
    private lateinit var button_bbreaket_right:Button
    private lateinit var button_00:Button
    private lateinit var button_11:Button
    private lateinit var button_22:Button
    private lateinit var button_33:Button
    private lateinit var button_44:Button
    private lateinit var button_55:Button
    private lateinit var button_66:Button
    private lateinit var button_77:Button
    private lateinit var button_88:Button
    private lateinit var button_99:Button
    private lateinit var button_dott:Button
    private lateinit var button_dividedd:Button
    private lateinit var button_multplyy:Button
    private lateinit var button_subb:Button
    private lateinit var button_pluss:Button
    private lateinit var button_equall:Button
    private lateinit var inputt:TextView
    private lateinit var outputt:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_cclear=findViewById(R.id.button_clear)
        button_bbreaket_left=findViewById(R.id.button_breaket_left)
        button_bbreaket_right=findViewById(R.id.button_breaket_right)
        button_00=findViewById(R.id.button_0)
        button_11=findViewById(R.id.button_1)
        button_22=findViewById(R.id.button_2)
        button_33=findViewById(R.id.button_3)
        button_44=findViewById(R.id.button_4)
        button_55=findViewById(R.id.button_5)
        button_66=findViewById(R.id.button_6)
        button_77=findViewById(R.id.button_7)
        button_88=findViewById(R.id.button_8)
        button_99=findViewById(R.id.button_9)
        button_dott=findViewById(R.id.button_dot)
        button_dividedd=findViewById(R.id.button_divided)
        button_multplyy=findViewById(R.id.button_multply)
        button_subb=findViewById(R.id.button_sub)
        button_pluss=findViewById(R.id.button_plus)
        button_equall=findViewById(R.id.button_equal)
        inputt=findViewById(R.id.input)
        outputt=findViewById(R.id.output)


        button_cclear.setOnClickListener {
            inputt.text=" "
            outputt.text=" "
        }
        button_bbreaket_left.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "(")
        }
        button_bbreaket_right.setOnClickListener {
            inputt.text=addToInputText(buttonValue = ")")
        }
        button_00.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "0")
        }
        button_11.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "1")
        }
        button_22.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "2")
        }
        button_33.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "3")
        }
        button_44.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "4")
        }
        button_55.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "5")
        }
        button_66.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "6")
        }
        button_77.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "7")
        }
        button_88.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "8")
        }
        button_99.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "9")
        }
        button_dott.setOnClickListener {
            inputt.text=addToInputText(buttonValue = ".")
        }
        button_dividedd.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "÷")
        }
        button_multplyy.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "×")
        }
        button_subb.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "-")
        }
        button_pluss.setOnClickListener {
            inputt.text=addToInputText(buttonValue = "+")
        }
        button_equall.setOnClickListener {
            showResult()
        }

    }
    private fun addToInputText(buttonValue:String):String{
        return "${inputt.text}$buttonValue"
    }
    private fun getInputExpression():String{
        var expression=inputt.text.replace(Regex("÷"),"/")
        expression=expression.replace(Regex("×"),"*")
        return expression
    }
    private fun showResult(){
        try {
            val expression=getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                outputt.text = "Error"
                outputt.setTextColor(ContextCompat.getColor(this, R.color.red))

            }else{
                outputt.text = DecimalFormat("0.######").format(result).toString()
                outputt.setTextColor(ContextCompat.getColor(this, R.color.green))
            }

        }
        catch (e: Exception){
            // Show Error Message
            outputt.text = "Error"
            outputt.setTextColor(ContextCompat.getColor(this, R.color.red))

        }

    }
}