package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TaskService {
     @Autowired
     private TaskRepository taskRepository;
     @Autowired
     private ProjectRepository projectRepository;

     @Autowired
     private AssigneesRepository assigneesRepository;



//    public Task addTask(Task task){
//     return taskRepository.save(task); }

//    public List<Task> getAllTask(){
//        return (List<Task>) taskRepository.findAll();
//    }
//




    public Project createTable(Integer project_id,int member_id){
         Project project =  projectRepository.findById(project_id).get();

         List<Table> tables = project.getTables();
         Table table =new Table(0,"New Table",null);
         Task task=new Task(0,"",""
                 ,member_id,"","","","",null,null);


         tables.add(table);
         project.setTables(tables);
         List<Task> taskList=new ArrayList<>();
         taskList.add(task);
         table.setTasks(taskList);


         return projectRepository.save(project);
   }

}

