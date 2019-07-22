package com.edunology.awsomezakedittext

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet

import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.awsome_edit_text.view.*




class AwesomeEditText : RelativeLayout {


    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0) : super(context, attrs, defStyle) {

        initialize(attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context,
                attrs: AttributeSet? = null,
                defStyle: Int,
                defStyleResource: Int): super(context, attrs, defStyle, defStyleResource) {

        initialize(attrs)
    }

    var borderColor: Int? = null
    var focusBorderColor: Int? = null
    var isClearable: Boolean = false
    var hasError = false

    private fun initialize(attrs: AttributeSet?) {

        attrs?.let {

            val typedArray = context.obtainStyledAttributes(it, R.styleable.AwesomeEditText)
            val hint = typedArray.getString(R.styleable.AwesomeEditText_hint)
            val title = typedArray.getString(R.styleable.AwesomeEditText_title)
            isClearable = typedArray.getBoolean(R.styleable.AwesomeEditText_is_clearable, false)

            var layout = R.layout.awsome_edit_text;
            if (typedArray.getBoolean(R.styleable.AwesomeEditText_is_rtl, false)) {

                layout = R.layout.awsome_rtl_edit_text;
            } //end if

            LayoutInflater.from(context).inflate(layout, this, true)


            editText.hint = hint
            upperHint.text = title

            //setting upper hint color
            upperHint.setBackgroundColor(typedArray.getColor(R.styleable.AwesomeEditText_upper_hint_background, ContextCompat.getColor(context, R.color.upper_hint_background)))
            upperHint.setTextColor(typedArray.getColor(R.styleable.AwesomeEditText_upper_hint_color, ContextCompat.getColor(context, R.color.upper_hint_color)))

            //setting border color
            borderColor = typedArray.getColor(R.styleable.AwesomeEditText_border_color, ContextCompat.getColor(context, R.color.border_color))
            focusBorderColor = typedArray.getColor(R.styleable.AwesomeEditText_focus_border_color, ContextCompat.getColor(context, R.color.focus_border_color))


            setBorderColor(borderColor!!)

            //setting edit text color

            editText.setTextColor(typedArray.getColor(R.styleable.AwesomeEditText_text_color, ContextCompat.getColor(context, R.color.text_color)))
            editText.setHintTextColor(typedArray.getColor(R.styleable.AwesomeEditText_upper_hint_color, ContextCompat.getColor(context, R.color.upper_hint_color)))

            editText.setOnFocusChangeListener {
                    view, hasFocus ->

                changeFocus(hasFocus)
            }

            typedArray.recycle()
        }

        editText.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                draw(p0?.length ?: 0)
            }


        })

        imgClear.setOnClickListener {

            editText.setText("")
        }



    }





    private fun changeFocus(hasFocus: Boolean) {

        var borderColor = this.borderColor!!

        if (hasError) { //if there is error don't change the color

            borderColor = ContextCompat.getColor(context, R.color.red)
        } else {

            if (hasFocus) {

                borderColor = focusBorderColor!!
            } //end if
        } //end if

        setBorderColor(borderColor)
    }



    private fun draw(length: Int) {

        if (length > 0) {

            if (isClearable) {

                imgClear.visibility = View.VISIBLE
            }//end if

            upperHint.visibility = View.VISIBLE
        } else {

            imgClear.visibility = View.GONE
            upperHint.visibility = View.GONE
        } //end if
    }


    fun setBorderColor(color: Int, width: Int = FOCUS_WIDTH) {

        val containerDrawable =  container.background  as GradientDrawable
        containerDrawable.setStroke(width, color)
    }

    fun setBorderColor(color: String, width: Int = FOCUS_WIDTH) {

        setBorderColor(Color.parseColor(color), width)
    }


    fun setError(hasError: Boolean) {

        this.hasError = hasError

        if (hasError) {

            setBorderColor(ContextCompat.getColor(context, R.color.red))
        } else {

            setBorderColor(borderColor!!)
        } //end if
    }


    var text: String

        get() = editText.text.toString().trim()
        set(value) {

            editText.setText(value)
        }

    companion object {

        const val FOCUS_WIDTH = 4
    }


}