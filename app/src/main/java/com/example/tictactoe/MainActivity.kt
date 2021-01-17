package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
   private var player:Int=1
   private var count:Int=0
    private lateinit var array:Array<Array<TextView>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerOneId.text = "Player 1 : X       <---"
        playerTwoId.text = getString(R.string.player_two)

         array=arrayOf(arrayOf(first,second,third),
                arrayOf(fourth,fifth,sixth),
                arrayOf(seventh,eighth,ninth))
        for(arr in array)
        {
            for(textview in arr)
            {
                textview.setOnClickListener(this)
            }
        }
    }
    override fun onClick(view: View)
    {
        when(view.id){
            R.id.first->{
                updateText(0,0)
            }
            R.id.second->{
                updateText(0,1)
            }
            R.id.third->{
                updateText(0,2)
            }
            R.id.fourth->{
                updateText(1,0)
            }
            R.id.fifth->{
                updateText(1,1)
            }
            R.id.sixth->{
                updateText(1,2)
            }
            R.id.seventh->{
                updateText(2,0)
            }
            R.id.eighth->{
                updateText(2,1)
            }
            R.id.ninth->{
                updateText(2,2)
            }
        }
        count++
        if(count==9)
        {
            displayResult(getString(R.string.match_draw))
        }
        else
        {
            checkWinner()
        }
        player= if(player==1){2} else{1}
        if(player==1){
            playerOneId.text="Player 1 : X      <---"
            playerTwoId.text=getString(R.string.player_two)
        }
        else
        {
            playerOneId.text=getString(R.string.player_one)
            playerTwoId.text="Player 2 : O      <---"
        }
    }
    fun checkWinner()
    {
        //for rows
        for(i in 0..2)
        {
            if(array[i][0].text==array[i][1].text && array[i][0].text==array[i][2].text)
            {
                if(array[i][0].text==getString(R.string.cross)){
                    displayResult(getString(R.string.player_one_wins))
                }
                else if(array[i][0].text==getString(R.string.zero))
                {
                    displayResult(getString(R.string.player_two_wins))
                }
            }
        }
        //for columns
        for(i in 0..2)
        {
            if(array[0][i].text==array[1][i].text && array[0][i].text==array[2][i].text)
            {
                if(array[0][i].text==getString(R.string.cross))
                {
                    displayResult(getString(R.string.player_one_wins))
                }
                else if(array[0][i].text==getString(R.string.zero))
                {
                    displayResult(getString(R.string.player_two_wins))
                }
            }
        }
        //left diagonal
        if(array[0][0].text==array[1][1].text && array[0][0].text==array[2][2].text)
        {
            if(array[0][0].text==getString(R.string.cross))
            {
                displayResult(getString(R.string.player_one_wins))
            }
            else if(array[0][0].text==getString(R.string.zero))
            {
                displayResult(getString(R.string.player_two_wins))
            }
        }
        //right diagonal
        if(array[0][2].text==array[1][1].text && array[0][2].text==array[2][0].text)
        {
            if(array[2][0].text==getString(R.string.cross))
            {
                displayResult(getString(R.string.player_one_wins))
            }
            else if(array[2][0].text==getString(R.string.zero))
            {
                displayResult(getString(R.string.player_two_wins))
            }
        }
    }
    fun updateText(row:Int,col:Int)
    {
        if(player==1)
        {
            array[row][col].apply {
                text=getString(R.string.cross)
                isEnabled=false
            }
        }
        else
        {
            array[row][col].apply {
                text=getString(R.string.zero)
                isEnabled=false
            }
        }
    }
    fun reset(view: View)
    {
        for(arr in array)
        {
            for(textview in arr)
            {
                textview.text=""
            }
        }
        enableAll()
        count=0
        playerOneId.text="Player 1 : X      <---"
        playerTwoId.text=getString(R.string.player_two)
        winTextId.text=""
        player=1
    }
    fun displayResult(result:String)
    {
        winTextId.text=result
        disableAll()
    }
    fun disableAll()
    {
        for(arr in array)
        {
            for(textview in arr)
            {
                textview.isEnabled=false
            }
        }
    }
    fun enableAll()
    {
        for(arr in array)
        {
            for(textview in arr)
            {
                textview.isEnabled=true
            }
        }
    }
}