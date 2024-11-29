package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App{

    //인스턴스 변수
    Scanner sc = new Scanner(System.in);
    int id=0;
    List<WiseSaying> wiseSayingList = new ArrayList<>();


    public void run() {

        System.out.println("== 명언 앱 ==");

       while(true){
           System.out.print("명령) ");
           String cmd = sc.nextLine();

           if(cmd.equals("종료")){
               return;
           } else if(cmd.equals("등록")){
               actionAdd();

           } else if(cmd.equals("목록")){
               System.out.println("번호 / 작가 / 명언");
               System.out.println("----------------------");

               for(WiseSaying wiseSaying : wiseSayingList.reversed()){
                   System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
               }
           }else if(cmd.startsWith("삭제?id=")){
               String strNum = cmd.substring(6); //"1"
               int deleteNum = Integer.parseInt(strNum); //1

               boolean removed = wiseSayingList.removeIf(e->e.getId()==deleteNum);

               if(removed){
                   System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteNum));
               }else{
                   System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteNum));
               }

           } else if(cmd.startsWith("수정?id=")){
               String strNum = cmd.substring(6); //"1"
               int modifyNum = Integer.parseInt(strNum); //1

                WiseSaying found = null;

                for(WiseSaying wiseSaying : wiseSayingList){
                    if(wiseSaying.getId()==modifyNum){
                        found=wiseSaying;
                        break;
                    }
                }

                if(found == null){
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyNum));
                }else{
                    System.out.println("명언(기존) : %s".formatted(found.getContent()));
                    System.out.print("명언: ");
                    String newContent = sc.nextLine();

                    System.out.println("작가(기존) : %s".formatted(found.getAuthor()));
                    System.out.print("작가: ");
                    String newAuthor = sc.nextLine();

                    found.setContent(newContent);
                    found.setAuthor(newAuthor);

                    System.out.println("%d번 명언이 수정되었습니다.".formatted(modifyNum));

                }



           }
       }



    }

     void actionAdd() {
        System.out.print("명언 :");
        String content = sc.nextLine();

        System.out.print("작가 :");
        String author = sc.nextLine();

        ++id;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayingList.add(wiseSaying);


        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }
}
