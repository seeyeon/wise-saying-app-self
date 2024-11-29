package com.ll;

class WiseSaying{

    private int id;
    private String content;
    private String author;

    WiseSaying(int id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //자바의 System.out.println() 메서드는 내부적으로 객체의 toString() 메서드를 자동으로 호출
    //그래서 그냥 기본으로 System.out.println(객체) -> 객체의 주소값이 출력
    //toString()으로 오버라이드 해줘야한다.
    @Override
    public String toString(){
        return "id: %d / 명언: %s/ 명언: %s".formatted(id, content, author);
    }
}