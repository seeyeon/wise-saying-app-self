package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {

    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("===명언 앱===");
        int id = 0;

        List<WiseSaying> sayingList = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                ++id;

                //객체 생성 및 생성자에 의해 매개변수로 객체 필드 초기화됨
                WiseSaying wiseSayings = new WiseSaying(id, content, author);

                sayingList.add(wiseSayings);

                System.out.println("%d번 명령이 등록되었습니다.".formatted(id));

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (WiseSaying wiseSaying : sayingList.reversed()) {
                    System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
                }

            } else if (cmd.startsWith("삭제?id=")) {
                String strId = cmd.substring(6);
                int deleteNum = Integer.parseInt(strId);

                //removeIF : 조건(Predicate)에 부합하는 요소를 제거, 반환값은 true, false임.
                boolean removed = sayingList.removeIf(e -> e.getId() == deleteNum);

                if (removed) {
                    System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteNum));
                } else {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteNum));
                }

            } else if (cmd.startsWith("수정?id=")) {
                String strId = cmd.substring(6);
                int modifyId = Integer.parseInt(strId);

                //modifyId와 기존 id가 일치하는 경우, 수정 진행
                //기존 id는 sayingList에 저장되어 있는데 어떻게 꺼내지..?

                WiseSaying foundWiseSaying = null; //찾고자 하는 객체

                for (WiseSaying wiseSaying : sayingList) {
                    if (wiseSaying.getId() == modifyId) {
                        foundWiseSaying = wiseSaying;
                        break; // 찾았으면 멈추기
                    }
                }

                if (foundWiseSaying == null) {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyId));
                }else{

                    System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
                    System.out.print("명언 : ");
                    String newContent = sc.nextLine();

                    System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
                    System.out.print("작가 : ");
                    String newAuthor = sc.nextLine();

                    foundWiseSaying.setContent(newContent);
                    foundWiseSaying.setAuthor(newAuthor);

                    System.out.println("%d번 명언이 수정되었습니다.".formatted(foundWiseSaying.getId()));
                    System.out.println("%d번 명언이 수정되었습니다.".formatted(modifyId));
                }

            }

        }

        sc.close(); //해제해주는 것도 잊지 말자!
    }
}
