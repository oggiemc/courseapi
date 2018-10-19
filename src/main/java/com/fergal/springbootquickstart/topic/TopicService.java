package com.fergal.springbootquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e055452 on 15/07/2018.
 */
@Service
public class TopicService {

     private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(
             new Topic("2", "Java for you", "All about java"),
             new Topic("1", "Yavascript for you", "Y'all about javascript")
     ));

     public List<Topic> getAllTopics(){
         return topicList;
     }

     public Topic getTopic(String id){
         return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
     }

    public Boolean addTopic(Topic topic) {
        topicList.add(topic);
        return true;
    }

    public void deleteTopic(String id) {
         topicList.remove(topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get());
    }

    public void updateTopic(Topic topic, String id) {
         for(int i = 0; i < topicList.size(); i++){
             if(topicList.get(i).getId().equals(id)){
                 System.out.println("Topic is " + topicList.get(i).getId());
                 topicList.set(i, topic);
                 return;
             }
         }
    }
}
