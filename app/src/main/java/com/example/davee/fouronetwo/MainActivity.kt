package com.example.davee.fouronetwo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {

    //define the listview
    var listNotes = ArrayList<Note>()
    //Array list of class 'Note'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add dummy data in the format [id, name, desc]
        listNotes.add(
            Note(
                1,
                "Clean house",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        );
        listNotes.add(
            Note(
                2,
                "Feed the cat",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        );
        listNotes.add(
            Note(
                3,
                "Mow the lawn",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        );

        //Set up adapter that is an instance of the notes adapter
        var myNotesAdapter = MyNotesAdapter(listNotes)
        //Use the ID of the listView layout in the main xml
        lvNotes.adapter = myNotesAdapter

    }

    //add data in the xml listview using an adapter class
    inner class MyNotesAdapter : BaseAdapter {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //gets the item and displays them on the XML list view. Use layout inflater
            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = listNotesAdapter[position]
            myView.textTitle.text = myNote.notename
            myView.textContent.text = myNote.noteDesc

            return myView
        }

        override fun getItem(position: Int): Any {
            return listNotesAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listNotesAdapter.size
            //sends the total number of items received
        }

        var listNotesAdapter = ArrayList<Note>()

        //constructor and base adapter constructor
        constructor(listNotes: ArrayList<Note>) : super() {
            this.listNotesAdapter = listNotes
            //This passes the data to the adapter

        }

    }


}
