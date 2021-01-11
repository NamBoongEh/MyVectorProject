import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class Main20210111Test {



    @Test // 초기 사이즈
    public void addTest() {
        Vector v = new Vector();

        assertTrue(v.size()==0);
    }
    @Test // 양수의 값 입력 후 사이즈 측정
    public void addTest2(){
        Vector v= new Vector();
        v.add(3);
        v.add(5);
        assertTrue(v.size()==2);
    }
    @Test // 음수 값 입력 후 사이즈 측정
    public void addTest3(){
        Vector v= new Vector();
        v.add(-3);
        assertTrue(v.size()==1);
    }
    @Test // 똑같은 0 값 여러개 입력 후 사이즈 측정
    public void addTest4(){
        Vector v= new Vector();
        v.add(0);
        v.add(0);
        v.add(0);
        v.add(0);
        v.add(0);
        assertTrue(v.size()==5);
    }
    @Test // for문을 이용하여, 양수, 음수, 0을 혼합하여 넣은 뒤 사이즈 측성
    public void addTest5(){
        Vector v= new Vector();
        for(int i=1; i<=99; i++){
            if(i%3==0){
                v.add(0);
            }
            else if(i%3==1){
                v.add(-i);
            }
            else if(i%3==2){
                v.add(i);
            }
        }
        assertTrue(v.size()==99);
    }
    // for문을 이용하여 값을 넣고, 용량 측정 후, 한 번 더 값을 넣고, 용량 변했는지 확인.
    @Test // 적은 양의 용량
    public void addTest8(){
        Vector v= new Vector();
        for(int i=1; i<=10; i++){
            if(i%3==0){
                v.add(0);
            }
            else if(i%3==1){
                v.add(-i);
            }
            else if(i%3==2){
                v.add(i);
            }
        }
        System.out.println(v.capacity());
        assertTrue(v.capacity()==10);
    }
    @Test // 큰 양의 용량(heap space 출력)
    public void addTest6(){
        Vector v= new Vector();
        for(int i=1; i<=1000000000; i++) {
            v.add(1);
        }
        System.out.println(v.capacity());
        assertTrue(v.size()==1000000000);
    }
    @Test // 큰 양의 용량2(heap space 출력)
    public void addTest9(){
        Vector v= new Vector();
        for(int i=1; i<=1000000000-1; i++){
            if(i%3==0){
                v.add(0);
            }
            else if(i%3==1){
                v.add(-i);
            }
            else if(i%3==2){
                v.add(i);
            }
        }
        System.out.println(v.capacity());
        assertTrue(v.size()==1000000000-1);
    }
    @Test // 용량 초과하여 넣어보기
    public void addTest7(){
        Vector v= new Vector();
        for(int i=1; i<=160; i++){
            if(i%3==0){
                v.add(0);
            }
            else if(i%3==1){
                v.add(-i);
            }
            else if(i%3==2){
                v.add(i);
            }
        }
        System.out.println("이전 용량은 " + v.capacity());
        v.add(161);
        System.out.println("증설된 용량은 " + v.capacity());
        assertTrue(v.capacity()==320);
    }

    @Test // 초기 비워진 상태
    public void isEmpty5() {
        Vector v = new Vector();
        assertTrue(v.isEmpty()==true);
    }
    @Test // 초기 비워진 상태(넣었다가 빼기,index 증가 버전)
    public void isEmpty2() {
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);
        v.remove(0);
        v.remove(1);
        assertTrue(v.isEmpty()==false);
    }
    @Test // 초기 비워진 상태(넣었다가 빼기,index 일정 버전)
    public void isEmpty3() {
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.remove(0);
        v.remove(0);
        assertTrue(v.isEmpty()==true);
    }
    @Test // 초기 비워진 상태(넣었다가 빼기,index 일부만 빼기 버전)
    public void isEmpty4() {
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.remove(1);
        assertTrue(v.isEmpty()==false);
    }

    @Test // clear 후 크기와 용량 측정
    public void clear(){
        Vector v= new Vector();
        v.clear();
        System.out.println(v.capacity());
        System.out.println(v.size());
        assertTrue(v.size()==0);
    }
    @Test // 중간 양의 용량(heap space 나오는거 전부 없애버리기)
    public void clear2(){
        Vector v= new Vector();
        for(int i=0; i<100; i++){
            v.add(i);
        }
        v.clear();
        System.out.println(v.capacity());
        System.out.println(v.size());
        assertTrue(v.capacity()==10);
    }
    @Test // 큰 양의 용량(heap space 나오는거 전부 없애버리기)
    public void clear3(){
        Vector v= new Vector();
        for(int i=0; i<1000000000; i++){
            v.add(i);
        }
        v.clear();
        System.out.println(v.capacity());
        System.out.println(v.size());
        assertTrue(v.capacity()==160);
    }

    @Test // index->객체 가져오기
    public void get(){
        Vector v= new Vector();
        for(int i=0; i<100; i++){
            v.add(i+1);
        }
        System.out.println(v.get(0));
        assertTrue(v.get(0).equals(1));
    }
    @Test // 객체->index 가져오기
    public void get2(){
        Vector v= new Vector();
        for(int i=0; i<100; i++){
            v.add(i+1);
        }
        System.out.println(v.indexOf(5));
        assertTrue(v.indexOf(1)==0);
    }
    @Test // 객체->index 가져오기2 지정한 객체의 크기를 넘어버리기
    public void get3(){
        Vector v= new Vector();
        for(int i=0; i<100; i++){
            v.add(i+1);
        }
        assertTrue(v.indexOf(101)==-1);
    }
    @Test // index->객체 가져오기2 지정한 index 넘어버리기
    public void get4(){
        Vector v= new Vector();
        for(int i=0; i<100; i++){
            v.add(i+1);
        }
        assertTrue(v.get(101).equals(100));
    }

    @Test // 용량 초과하여 넣어보기(설정값 320보다 큰 수 넣기)
    public void ensureCapacity3(){
        Vector v= new Vector();
        for(int i=1; i<=160; i++){
            v.add(i);
        }
        System.out.println("이전 용량은 " + v.capacity());
        v.add(161);
        System.out.println("증설된 용량은 " + v.capacity());
        v.ensureCapacity(400);
        System.out.println("수정된 용량은 " + v.capacity());

        assertTrue(v.capacity()==400);
    }
    @Test // 용량 초과하여 넣어보기(설정값 320보다 작은 수 넣기)
    public void ensureCapacity2(){
        Vector v= new Vector();
        for(int i=1; i<=160; i++){
            v.add(i);
        }
        System.out.println("이전 용량은 " + v.capacity());
        v.add(161);
        System.out.println("증설된 용량은 " + v.capacity());
        v.ensureCapacity(160);
        System.out.println("수정된 용량은 " + v.capacity());

        assertTrue(v.capacity()==320);
    }

    @Test // 마지막 값을 remove한다, 용량이 320이 그대로인지 확인
    public void remove(){
        Vector v= new Vector();
        for(int i=1; i<=160; i++){
            v.add(i);
        }
        System.out.println("이전 용량은 " + v.capacity());
        v.add(161);
        System.out.println("증설된 용량은 " + v.capacity());
        v.remove(160);
        v.ensureCapacity(160);
        System.out.println("수정된 용량은 " + v.capacity());

        assertTrue(v.capacity()==320);
    }
    @Test // 중간 값을 remove한다, 삭제 후 그 값 찾아보기 (지정된 객체의 index값 못찾음)
    public void remove2(){
        Vector v= new Vector();
        for(int i=0; i<=160; i++){
            v.add(i);
        }
        v.remove(10);
        System.out.println(v.indexOf(10));
        assertTrue(v.indexOf(10)==-1);
    }
    @Test // 중간 값을 remove한다, 삭제 후 그 값 찾아보기 (한 칸씩 밀린 것을 확인)
    public void remove3(){
        Vector v= new Vector();
        for(int i=0; i<=160; i++){
            v.add(i);
        }
        v.remove(10);
        System.out.println(v.get(10));
        assertTrue(v.get(10).equals(11));
    }
    @Test // 중간 값을 remove한다, 삭제 후 그 값 찾아보기 (한 칸씩 밀린 것을 확인)
    public void remove4(){
        Vector v= new Vector();
        for(int i=0; i<=160; i++){
            v.add(i);
        }
        v.remove(v.remove(159));
        System.out.println(v.get(159));
        assertTrue(v.get(159).equals(160));
    }


}