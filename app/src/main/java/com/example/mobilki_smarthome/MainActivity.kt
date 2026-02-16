package com.example.mobilki_smarthome

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var numberOfViews = 1
        val sbValue = findViewById<SeekBar>(R.id.sbValue)
        var tvValue = findViewById<TextView>(R.id.tvValue)
        var btnCommit = findViewById<Button>(R.id.btnCommit)
        var swHeat = findViewById<Switch>(R.id.swHeat)
        var tvLogStatus = findViewById<TextView>(R.id.tvLogStatus)
        var tvLogsHistoryLayout = findViewById<LinearLayout>(R.id.tvLogsHistoryLayout)

        btnCommit.setOnClickListener {

            val newTextView = TextView(this)
            newTextView.setText("Numer: ${numberOfViews} Status: ${swHeat.isChecked} Moc: ${sbValue.progress}%")
            tvLogsHistoryLayout.addView(newTextView , 0)
            tvLogStatus.text = "Pomyślnie dodano wpis nr: ${numberOfViews}"
            tvLogStatus.setTextColor(Color.parseColor("#008577"))

            numberOfViews+=1
        }
        sbValue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                tvValue.text = "Moc Oświetlenia: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}