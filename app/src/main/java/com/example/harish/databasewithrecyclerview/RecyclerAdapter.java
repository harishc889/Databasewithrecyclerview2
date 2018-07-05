package com.example.harish.databasewithrecyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentViewHolder>
{

    private static final String TAG = RecyclerAdapter.class.getName();

    private final ListItemClickListener itemClickListener;
    public DatabaseHelper databasehelper;
    private static int viewHolderCount;

    private ArrayList<Student> studentModelArrayList;

    public interface ListItemClickListener {
        void onListItemClickListener(int clickedItemIndex);
    }

    public RecyclerAdapter(ArrayList<Student> studentModelArrayList,ListItemClickListener itemClickListener)
    {
        this.studentModelArrayList = studentModelArrayList;
        this.itemClickListener = itemClickListener;
        viewHolderCount = 0;
    }

    @NonNull

    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itemlayout, parent,
                false);

        StudentViewHolder studentViewHolder = new StudentViewHolder(view);
//        studentViewHolder.recyclerNumber.setText("" + viewHolderCount);

        viewHolderCount = viewHolderCount + 1;

        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.StudentViewHolder holder,
                                 int position) {
        Student student = studentModelArrayList.get(position);
        holder.studentName.setText("" + student.name);
        holder.collegeName.setText("" + student.collegeName);
        holder.studentId.setText("" + student.id);
    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

    public class StudentViewHolder extends
            RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView studentName;
        TextView collegeName;
        TextView studentId;


        public StudentViewHolder(View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.student_name);
            collegeName = itemView.findViewById(R.id.college_name);
            studentId = itemView.findViewById(R.id.studentid);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            itemClickListener.onListItemClickListener(clickedPosition);
        }
    }
}