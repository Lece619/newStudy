/*
https://school.programmers.co.kr/learn/courses/30/lessons/72410
        2021 KAKAO BLIND RECRUITMENT
        신규 아이디 추천
        Level1

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. ) -> level4
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/
package kakao2021;

public class RecommendId {

    public String solution(String new_id) {
        Id makeId = new Id(new_id);
        return makeId.level1().level2().level3().level4().level5().level6().level7().getId();
    }


    static class Id{
        private String id;

        public Id(String id) {
            this.id = id;
        }

        public Id level1(){
            this.id = id.toLowerCase();
            return this;
        }

        public Id level2(){
            this.id = id.replaceAll("[^a-z0-9-_.]","");
            return this;
        }

        public Id level3(){
            this.id = id.replaceAll("\\.{2,}",".").replaceAll("^[.]|[.]$","");
            return this;
        }

        public Id level4(){
            this.id = id.replaceAll("^[.]|[.]$","");
            return this;
        }

        public Id level5(){
            this.id = id.equals("") ? "a" : id;
            return this;
        }

        public Id level6(){
            this.id = id.length() >= 16 ? id.substring(0,15) : id;
            return this.level4();
        }

        public Id level7(){
            int length = id.length();
            this.id = length <= 2 ? (id+id.charAt(length -1)+id.charAt(length -1)).substring(0,3) : id;
            return this;
        }


        public String getId() {
            return id;
        }
    }


    public static void main(String[] args) {
        RecommendId recommendId = new RecommendId();
        String new_id ="...!@BaT#*..y.abcdefghijklm.";
        new_id="123_.def";
        System.out.println("recommendId = " + recommendId.solution(new_id));
    }
}
