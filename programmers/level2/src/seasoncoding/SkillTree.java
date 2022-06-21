package seasoncoding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class SkillTree {
    public static Queue<Character> queue;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        queue = new LinkedList<>();
        IntStream.range(0,skill.length()).forEach(i->queue.add(skill.charAt(i)));

        System.out.println(queue);
        for (String skill_tree : skill_trees) {
            answer += checkSkill(skill_tree);
        }
        checkSkill("123");

        return answer;
    }

    public int checkSkill(String skillTree){
        Queue<Character> temp = new LinkedList<>();
        temp.addAll(queue);
        for (int i = 0; i < skillTree.length(); i++) {
            char now = skillTree.charAt(i);
            if(temp.contains(now)){
                if(temp.peek() == now){
                    temp.poll();
                }else{
                    return 0;
                }
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        String[] name = {"BACDE", "CBADF", "AECB", "BDA"};
        new SkillTree().solution("CBD",name);
    }
}
