package com.mobile.apicall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Todo> todoList;

    public TodoAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.tvWhat.setText("Todo: " + todo.getWhat());
        holder.tvTime.setText("Time: " + todo.getTime());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWhat;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWhat = itemView.findViewById(R.id.tvWhat);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}