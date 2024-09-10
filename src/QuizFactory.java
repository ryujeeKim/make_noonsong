import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class QuizFactory {
    private Map<Integer, List<Quiz>> quizPool;
    static List<Integer> randomLists;
    private int selectedDifficulty;

    public QuizFactory() {
        quizPool = new LinkedHashMap<>();
        populateQuizzes(selectedDifficulty);
    }

    private void populateQuizzes(int selectedDifficulty) {
        // Example quizzes for difficulty level 1
        quizPool.put(1, Arrays.asList(
            new OXQuiz("<html>type()함수는 데이터 타입을 판별한다.</html>", true, 1, "<html>type() 함수는 데이터 타입을 판별하는 함수입니다.</html>", 1),
            new OXQuiz("<html>리스트는 변경할 수 없는 데이터 타입이다.</html>", false, 1, "<html>파이썬에서 리스트(list)는 가변(mutable) 객체입니다.<br>즉, 리스트의 요소를 추가, 삭제 또는 변경할 수 있습니다.<br>예를 들어, my_list = [1, 2, 3] 이라는 리스트가 있을 때,<br>my_list.append(4) 를 통해 리스트에 새로운 요소를 추가할 수 있습니다.</html>", 2),
            new OXQuiz("<html>파이썬에서 딕셔너리의 키는 고유해야 한다.</html>", true, 1, "<html>딕셔너리에서 키는 고유해야 하며, 중복된 키를 사용할 수 없습니다.<br>동일한 키를 사용하면 마지막에 할당된 값으로 덮어쓰게 됩니다.</html>", 3),
            new OXQuiz("<html>\\n의 역할은 탭을 의미한다</html>", false, 1, "<html>\\n의 역할은 줄 바꿔쓰기를 의미합니다. \\t는 탭을 의미합니다</html>", 4),
            new OXQuiz("<html>파이썬에서 %연산자는 나누기 연산자이다.</html>", false, 1, "<html>%연산자는 나머지 연산자이다.</html>", 5),
            new OXQuiz("<html>파이썬은 인터프리터 언어이다.</html>", true, 1, "<html>파이썬은 코드를 실행 시에 바로 해석하여 실행하는 인터프리터 언어이다.</html>", 6),
            new OXQuiz("<html>파이썬에서는 함수 내에서 전역 변수를 수정할 수 있다.</html>", true, 1, "<html>파이썬에서는 함수 내에서 전역 변수를 수정할 수 있지만,<br>이를 위해서는 global 키워드를 사용해야 합니다.</html>", 7),
            new OXQuiz("<html>파이썬에서 딕셔너리(Dictionary)는 키(key)와 값(value) 쌍으로 구성된다.</html>", true, 1, "<html>딕셔너리는 데이터를 키와 값의 쌍으로 저장하는 자료형이다.<br>키는 유일해야 하며, 이를 통해 값을 빠르게 조회할 수 있다.</html>", 8)
        ));
    
        // Example quizzes for difficulty level 2
        quizPool.put(2, Arrays.asList(
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 리스트를 올바르게 초기화하는 방법은 무엇입니까?</html>",
                Arrays.asList("<html>list = (1, 2, 3)</html>", "<html>list = [1, 2, 3]</html>", "<html>list = {1, 2, 3}</html>"), "<html>list = [1, 2, 3]</html>", 2, "<html>리스트는 대괄호([])를 사용하여 초기화한다.<br>소괄호(())는 튜플을, 중괄호({})는 세트를 초기화하는 데 사용된다.</html>", 9),
            new MultipleChoiceQuiz("<html>다음 중 if 문이 올바르게 작성된 것은 무엇입니까?</html>",
                Arrays.asList("<html>if x = 5:</html>", "<html>if x == 5</html>", "<html>if (x == 5):</html>"), "<html>if (x == 5):</html>", 2, "<html>if 문은 조건식이 참일 때 실행될 코드 블록을 지정하는 데 사용된다.<br>조건식에서는 비교 연산자(==)를 사용해야 하며, if 문 뒤에는 콜론(:)이 필요하다.<br>3번 선택지는 이러한 조건을 모두 만족한다.</html>", 10),
            new MultipleChoiceQuiz("<html>다음 리스트 A에서 요소 7에 접근하려고 한다. 올바른 접근법은 무엇인가.<br>A = [1,3,5,7,9]</html>",
                Arrays.asList("<html>A[3]</html>", "<html>A[4]</html>", "<html>A[5]</html>"), "<html>A[3]</html>", 2, "<html>파이썬 리스트의 인덱스는 0부터 시작하므로 네번째 요소인 7의 인덱스는 3이다.</html>", 11),
            new MultipleChoiceQuiz("<html>다음 파이썬의 변수 이름 중 합법적인 변수 이름에 해당하지 않는 것은 무엇인가.</html>",
                Arrays.asList("<html>snow_flake</html>", "<html>1906snow</html>", "<html>_apple</html>"), "<html>1906snow</html>", 2, "<html>변수명은 숫자로 시작할 수 없다.</html>", 12),
            new MultipleChoiceQuiz("<html>letters = ‘snowflake’에서 letters가 바인딩하는 문자열에서 첫번째와 다섯번째 문자를 출력하는 방법은?</html>",
                Arrays.asList("<html>lang =‘snowflake’<br>print(lang[1], lang[3])</html>", "<html>lang =‘snowflake’<br>print(lang[0], lang[4])</html>", "<html>lang =‘snowflake’<br>print(lang[0], lang[5])</html>"), "<html>lang =‘snowflake’<br>print(lang[0], lang[4])</html>", 2, "<html>파이썬 문자열에서 한 글자를 가져오는 것을 인덱싱이라고 부른다.<br>파이썬 인덱싱은 0부터 시작한다. 따라서 첫번째는 lang[0]이며 5번째 글자는 lang[4]로 가져올 수 있다.</html>", 13),
            new MultipleChoiceQuiz("<html>아래 코드의 실행결과를 고르시오.<br>a =”3”<br>b = “4”<br>print(a+b)</html>",
                Arrays.asList("<html>7</html>", "<html>34</html>", "<html>ab</html>"), "<html>34</html>", 2, "<html>숫자에 “”가 있기 때문에 이 숫자는 문자열에 대한 변수라고 할 수 있습니다.<br>print함수에는 문자열 두개가 더해져있기 때문에 7이 아니라 34가 답이 될 수 있습니다.</html>", 14),
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 문자열을 슬라이싱하는 올바른 방법은 무엇인가?</html>",
                Arrays.asList("<html>my_string.cut(1:3)</html>", "<html>my_string[1:3]</html>", "<html>my_string.slice(1, 3)</html>"), "<html>my_string[1:3]</html>", 2, "<html>슬라이싱은 대괄호 안에 시작 인덱스와 끝 인덱스를 콜론으로 구분하여 지정하고,<br> 끝 인덱스는 포함하지 않는다.</html>", 15),
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 변수 x에 10을 더하는 올바른 방법은 무엇인가?</html>",
                Arrays.asList("<html>x = x + 10</html>", "<html>x := 10</html>", "<html>x =+ 10</html>"), "<html>x = x + 10</html>", 2, "<html>변수에 값을 더하고 다시 할당하는 방법으로 'x = x + 10'이 기본적인 형태이다.<br>이는 x의 현재 값에 10을 더한 결과를 x에 다시 저장한다.</html>", 16)
        ));
    
        // Example quizzes for difficulty level 3
        quizPool.put(3, Arrays.asList(
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 함수 정의가 올바르게 된 것은 무엇입니까?</html>",
                Arrays.asList("<html>def my_function:</html>", "<html>function my_function():</html>", "<html>def my_function()</html>", "<html>def my_function():</html>"), "<html>def my_function():</html>", 3, "<html>파이썬에서 함수는 'def'키워드를 사용하며 정의하며, 함수명 뒤에는 반드시 괄호와 콜론이 필요하다.</html>", 17),
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 튜플(Tuple)의 특징이 아닌 것은?</html>",
                Arrays.asList("<html>튜플은 순서가 있다.</html>", "<html>튜플은 변경할 수 없다.</html>", "<html>튜플은 중복을 허용하지 않는다.</html>", "<html>튜플은 다양한 데이터 타입을 가질 수 있다.</html>"), "<html>튜플은 중복을 허용하지 않는다.</html>", 3, "<html>튜플은 리스트와 유사하지만,변경 불가능하다.<br>순서가 있으며 중복을 허용하고 다양한 데이터 타입을 가질 수 있다.<br>튜플의 요소는 한번 정의되면 변경할 수 없다.</html>", 18),
            new MultipleChoiceQuiz("<html>파이썬의 다음 네가지 자료형 중, 아래의 설명과 가장 가까운 것은?<br>수정 불가능(immutable)한 자료형으로, 소괄호()로 둘러싸 표현한다.<br>여러개의 요소를 가질 수 있으며, 중복된 요소를 가질 수 있으나 후에 요소를 추가하거나 삭제할 수 없다.</html>",
                Arrays.asList("<html>리스트(list)</html>", "<html>세트(set)</html>", "<html>튜플(tuple)</html>", "<html>딕셔너리(dictionary)</html>"), "<html>튜플(tuple)</html>", 3, "<html>위의 설명에 해당하는 자료형은 튜플(tuple)이다.</html>", 19),
            new MultipleChoiceQuiz("<html>다음 코드의 출력 값은?<br>def test(a,b):<br>&emsp;return int(a/b)<br><br>print(test(1,2))</html>",
                Arrays.asList("<html>0</html>", "<html>0.5</html>", "<html>1</html>", "<html>2</html>"), "<html>0</html>", 3, "<html>return문의 int(a/b)에 의해 소수점 아래 숫자가 잘려나간다.<br>즉, 1/2의 연산 결과인 0.5에서 소수점 아래 숫자가 잘려나가므로,<br> 최종 출력 값은 0이 된다.</html>", 20),
            new MultipleChoiceQuiz("<html>다음 파이썬 코드의 실행 결과는 무엇인가요?<br>def my_function(x, y=5):<br>&emsp;return x + y<br><br>print(my_function(3))</html>",
                Arrays.asList("<html>3</html>", "<html>5</html>", "<html>8</html>", "<html>None of the above</html>"), "<html>8</html>", 3, "<html>my_function(3)는 인수 x에 3을 할당하고,<br> y는 기본값 5를 사용하여 x와 y를 더한 결과인 8을 반환한다.</html>", 21),
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 리스트 내포(List Comprehension)의 사용 예시가 아닌 것은 무엇인가요?</html>",
                Arrays.asList("<html>[x for x in range(5)]</html>", "<html>[x for x in range(10) if x % 2 == 0]</html>", "<html>{x: x*2 for x in range(5)}</html>", "<html>[x for x in [1, 2, 3]]</html>"), "<html>{x: x*2 for x in range(5)}</html>", 3, "<html>리스트 내포(List Comprehension)는 리스트를 생성하기 위한 간결하고 효율적인 방법으로,<br>대괄호를 사용하여 표현한다.<br>중괄호는 딕셔너리 내포(Dictionary Comprehension)를 나타낸다.</html>", 22),
            new MultipleChoiceQuiz("<html>다음 중 파이썬에서 패키지(Package)를 설명하는 올바른 방법은 무엇입니까?<br>(패키지는 무엇인가?)</html>",
                Arrays.asList("<html>패키지는 파이썬 코드를 묶는 방법으로,<br>다양한 모듈을 포함할 수 있다.</html>", "<html>패키지는 파이썬에서 조건문을 작성하는 방법이다.</html>", "<html>패키지는 파이썬에서 반복문을 생성하는 방법이다.</html>", "<html>패키지는 파이썬의 데이터 타입 중 하나이다.</html>"), "<html>패키지는 파이썬 코드를 묶는 방법으로,<br>다양한 모듈을 포함할 수 있다.</html>", 3, "<html>패키지는 파이썬 코드의 재사용성을 높이고,<br>코드 관리를 용이하게 하기 위해 사용되는 모듈들의 모음이다.<br>패키지는 디렉토리 형태로 존재하며,<br>__init__.py 파일을 포함하여 해당 디렉토리가 패키지임을 나타낸다.</html>", 23),
            new MultipleChoiceQuiz("<html>다음 코드의 실행 결과는 무엇인가요?<br>my_list = [1, 2, 3, 4, 5]<br>print(my_list[2:4])</html>",
                Arrays.asList("<html>[2, 3]</html>", "<html>[2, 3, 4]</html>", "<html>[3, 4]</html>", "<html>[3, 4, 5]</html>"), "<html>[3, 4]</html>", 3, "<html>리스트의 슬라이싱은 시작 인덱스와 끝 인덱스를 사용하여 하며,<br>끝 인덱스는 포함되지 않는다.<br>my_list[2:4]는 인덱스 2와 3에 해당하는 요소를 가져오므로 [3, 4]가 된다.</html>", 24)
        ));
        quizPool.put(4, Arrays.asList(
    new ShortAnswerQuiz("<html>파이썬에서 주석(comments)을 작성할 때 사용하는 기호는 무엇인가?</html>", "#", 4, "<html>파이썬에서 주석은 '#'기호로 시작하며, <br>주석 뒤의 모든 텍스트는 실행되지 않는다.</html>", 25),
    new ShortAnswerQuiz("<html>리스트 numbers에서 최대값을 변수 max_num에 저장하는 한 줄의 코드를 작성하세요.</html>", "max_num=max(numbers)", 4, "<html>'max()' 함수는 리스트나 다른 반복 가능한 객체에서 가장 큰 요소를 반환한다.<br>리스트 numbers의 최대값을 구하고 이를 변수 max_num에 저장할 수 있다.</html>", 26),
    new ShortAnswerQuiz("<html>다음 프로그램은 리스트의 모든 원소를 더하여 반환하는 list_sum함수이다.<br> 괄호 속에 올바르게 함수를 정의해 보시오.<br>( &emsp;  &emsp; &emsp; )<br> &emsp; sum1 = 0<br> &emsp; for  item in mylist :<br> &emsp; &emsp;sum1 += item<br> &emsp;  &emsp;return sum1</html>", "def list_sum(mylist):", 4, "<html>파이썬 함수정의 규칙은 다음과 같다.<br>def 함수이름(매개변수):<br>실행문</html>", 27),
    new ShortAnswerQuiz("<html>for문을 이용하여 오늘의 메뉴를 출력하라. list = [\"김밥\", \"라면\", \"튀김\"]<br>for 메뉴 in (  ):<br> &emsp; print(\"오늘의 메뉴: \" + list)</html>", "list", 4, "<html>for문은 횟수가 있는 반복문입니다. for문을 만난 프로그램은 우선 in 키워드가 가리키는 문자열,<br>튜플 또는 리스트의 요소들을 꺼내 변수에 대입합니다.</html>", 28),
    new ShortAnswerQuiz("<html>리스트에 주식 종목 이름이 저장되어 있다.<br>각 단어의 문자열의 길이를 출력하기 위해서는 print에 어떻게 써야하는가?<br>리스트 = [\"SK하이닉스\", \"삼성전자\", \"LG전자\"]<br><pre>for 종목명 in 리스트: <br> &emsp; print(     )</pre></html>", "len(종목명)", 4, "<html>문자열 길이를 출력하기 위해서는 len() 함수를 이용할 수 있습니다.<br>for문을 통해 리스트의 요소들을 꺼내 반복하고 있으므로 <br>len(종목명)이라고 작성해야합니다.</html>", 29),
    new ShortAnswerQuiz("<html>1에서 100까지 홀수 값들의 합을 구하는 프로그램을 작성하려 한다. 괄호에 들어갈 정수는?<br>sum = 0<br>count = 1<br>while count <= 100:<br>( &emsp; )sum =  sum + count( &emsp; )count = count + ( &emsp; )</html>", "2", 4, "<html>홀수의 합을 구하는 프로그램이므로, <br>변수 count를 루프를 한 번 돌 때 1부터 2씩 증가시키면 홀수 값만을 가지게 된다.<br>이를 변수 sum에 누적시킨다.</html>", 30),
    new ShortAnswerQuiz("<html>다음 코드는 리스트 'numbers'의<br>모든 요소를 더하여 'total'에 저장하는 코드이다.<br> 빈칸에 알맞은 연산자를 써넣으시오.<br>numbers=[1,2,3,4,5]<br>total=0<br>for number in numbers<br>total (   ) number</html>", "+=", 4, "<html>'+='연산자는 더하고 할당하기 연산자이다. 이는 'total=total+number'와 동일하다</html>", 31),
    new ShortAnswerQuiz("<html>다음 코드는 함수'multiply'를<br>정의하고 두 숫자를 곱한 결과를 반환하는 코드이다.<br>빈칸에 알맞은 코드를 작성하시오.<br>(   ) multiply(a,b):<br>  return a*b <br>result=multiply(3,4)<br>print(result)</html>", "def", 4, "<html>함수는 'def'키워드를 사용하여 정의한다.</html>", 32)
));

    }
    
    //사용자가 선택한 난이도를 설정하는 메소드
    public void setSelectedDifficulty(int difficulty){
        this.selectedDifficulty=difficulty;
    }

    // 현재 선택된 난이도를 반환하는 메소드
    public int getSelectedDifficulty() {
        return selectedDifficulty;
    }


    //퀴즈를 로드
    public Quiz getRandomQuiz(int difficulty,int pageindex) {
        List<Quiz> quizzes = quizPool.get(difficulty);
        return quizzes.get(this.randomLists.get(pageindex));
    }

    //처음 퀴즈 다섯개 준비할 때 실행 됨
    public void prepareQuiz(int difficulty){
        List<Quiz> quizzes = quizPool.get(difficulty);
        List<Integer> preparedList = makeRandomList(quizzes.size());
        this.randomLists = preparedList; //만들어진 5개 랜덤 숫자 리스트 !!
        System.out.println(this.randomLists);
    }

    //랜덤한 숫자 리스트(5개) 만드는 메소드
    public static List<Integer> makeRandomList(int listsize){

        List<Integer> lists = new ArrayList<>();
        Random random = new Random();
        int randNumber;

        //다섯개가 뽑힐 때까지
        while(lists.size() < 5){
            //무작위 숫자 생성
            randNumber = random.nextInt(listsize);

            //중복 여부 체크(중복이 아니면 추가)
            if (!lists.contains(randNumber)) {
                lists.add(randNumber);
            }
        }
        
        return lists;
    }

    public Map<Integer, List<Quiz>> getQuizPool() {
        return quizPool;
    }
}

