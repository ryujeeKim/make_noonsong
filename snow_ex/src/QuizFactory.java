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
            new OXQuiz("type()함수는 데이터 타입을 판별한다.", true, 1,"type() 함수는 데이터 타입을 판별하는 함수입니다.",1),
            new OXQuiz("리스트는 변경할 수 없는 데이터 타입이다.", false, 1,"파이썬에서 리스트(list)는 가변(mutable) 객체입니다.\n즉, 리스트의 요소를 추가, 삭제 또는 변경할 수 있습니다. \n예를 들어, my_list = [1, 2, 3] 이라는 리스트가 있을 때, \nmy_list.append(4) 를 통해 리스트에 새로운 요소를 추가할 수 있습니다."
            ,2),
            new OXQuiz("파이썬에서 딕셔너리의 키는 고유해야 한다.", true, 1,"딕셔너리에서 키는 고유해야 하며, 중복된 키를 사용할 수 없습니다.\n동일한 키를 사용하면 마지막에 할당된 값으로 덮어쓰게 됩니다.",3),
            new OXQuiz("\\n의 역할은 탭을 의미한다", false, 1,"\\n" + //
                                "의 역할은 줄 바꿔쓰기를 의미합니다. \\t는 탭을 의미합니다",4),
            new OXQuiz("파이썬에서 %연산자는 나누기 연산자이다.", false, 1,"%연산자는 나머지 연산자이다.",5),
            new OXQuiz("파이썬은 인터프리터 언어이다.", true, 1,"파이썬은 코드를 실행 시에 바로 해석하여 실행하는 인터프리터 언어이다.",
            6),
            new OXQuiz("파이썬에서는 함수 내에서 전역 변수를 수정할 수 있다.", true, 1,"파이썬에서는 함수 내에서 전역 변수를 수정할 수 있지만,\n 이를 위해서는 global 키워드를 사용해야 합니다.",
            7),
            new OXQuiz("파이썬에서 딕셔너리(Dictionary)는 키(key)와 값(value) 쌍으로 구성된다.", true, 1,"딕셔너리는 데이터를 키와 값의 쌍으로 저장하는 자료형이다. \n키는 유일해야 하며, 이를 통해 값을 빠르게 조회할 수 있다.",8)
        ));
    
        // Example quizzes for difficulty level 2
        quizPool.put(2, Arrays.asList(
            new MultipleChoiceQuiz("다음 중 파이썬에서 리스트를 올바르게 초기화하는 방법은 무엇입니까?",
                Arrays.asList("list = (1, 2, 3)", "list = [1, 2, 3]", "list = {1, 2, 3}"), "list = [1, 2, 3]", 2, "리스트는 대괄호([])를 사용하여 초기화한다.\n소괄호(())는 튜플을, 중괄호({})는 세트를 초기화하는 데 사용된다.", 9),
            new MultipleChoiceQuiz("다음 중 if 문이 올바르게 작성된 것은 무엇입니까?",
                Arrays.asList("if x = 5:", "if x == 5", "if (x == 5):"), "if (x == 5):", 2, "if 문은 조건식이 참일 때 실행될 코드 블록을 지정하는 데 사용된다.\n조건식에서는 비교 연산자(==)를 사용해야 하며, if 문 뒤에는 콜론(:)이 필요하다.\n3번 선택지는 이러한 조건을 모두 만족한다.", 10),
            new MultipleChoiceQuiz("다음 리스트 A에서 요소 7에 접근하려고 한다. 올바른 접근법은 무엇인가.\nA = [1,3,5,7,9]",
                Arrays.asList("A[3]", "A[4]", "A[5]"), "A[3]", 2, "파이썬 리스트의 인덱스는 0부터 시작하므로 네번째 요소인 7의 인덱스는 3이다."
                                        , 11),
            new MultipleChoiceQuiz("다음 파이썬의 변수 이름 중 합법적인 변수 이름에 해당하지 않는 것은 무엇인가.",
                Arrays.asList("snow_flake", "1906snow", "_apple"), "1906snow", 2, "변수명은 숫자로 시작할 수 없다.", 12),
            new MultipleChoiceQuiz("letters = ‘snowflake’에서 letters가 바인딩하는 문자열에서 첫번째와 다섯번째 문자를 출력하는 방법은?",
                Arrays.asList("lang =‘snowflake’\nprint(lang[1], lang[3])", "lang =‘snowflake’\nprint(lang[0], lang[4])", "lang =‘snowflake’\nprint(lang[0], lang[5])"), "lang =‘snowflake’\nprint(lang[0], lang[4])", 2, " 파이썬 문자열에서 한 글자를 가져오는 것을 인덱싱이라고 부른다. 파이썬 인덱싱은 0부터 시작한다. 따라서 첫번째는 lang[0]이며 5번째 글자는 lang[4]로 가져올 수 있다.", 
                13),
            new MultipleChoiceQuiz("아래 코드의 실행결과를 고르시오.\na =”3” \nb = “4” \nprint(a+b)\n",
                Arrays.asList("7", "34", "ab"), "34", 2, "숫자에 “”가 있기 때문에 이 숫자는 문자열에 대한 변수라고 할 수 있습니다. print함수에는 문자열 두개가 더해져있기 때문에 7이 아니라 34가 답이 될 수 있습니다.\r\n", 14),
            new MultipleChoiceQuiz("다음 중 파이썬에서 문자열을 슬라이싱하는 올바른 방법은 무엇인가?",
                Arrays.asList("my_string.cut(1:3)", "my_string[1:3]", "my_string.slice(1, 3)"), "my_string[1:3]", 2, "슬라이싱은 대괄호 안에 시작 인덱스와 끝 인덱스를 콜론으로 구분하여 지정하고,\n 끝 인덱스는 포함하지 않는다.", 15),
            new MultipleChoiceQuiz("다음 중 파이썬에서 변수 x에 10을 더하는 올바른 방법은 무엇인가?",
            Arrays.asList("x = x + 10", "x := 10", "x =+ 10"), "x = x + 10", 2,"변수에 값을 더하고 다시 할당하는 방법으로 'x = x + 10'이 기본적인 형태이다.\n이는 x의 현재 값에 10을 더한 결과를 x에 다시 저장한다."
            , 16)
        ));
    
        // Example quizzes for difficulty level 3
        quizPool.put(3, Arrays.asList(
            new MultipleChoiceQuiz("다음 중 파이썬에서 함수 정의가 올바르게 된 것은 무엇인가?",
                Arrays.asList("def my_function:", "function my_function():", "def my_function()", "def my_function():"), "def my_function():", 3, "파이썬에서 함수는 'def'키워드를 사용하며 정의하며, 함수명 뒤에는 반드시 괄호와 콜론이 필요하다.", 17),
            new MultipleChoiceQuiz("다음 중 파이썬에서 튜플(Tuple)의 특징이 아닌 것은?",
                Arrays.asList("튜플은 순서가 있다.", "튜플은 변경할 수 없다.", "튜플은 중복을 허용하지 않는다.", "튜플은 다양한 데이터 타입을 가질 수 있다."), "튜플은 중복을 허용하지 않는다.", 3, "튜플은 리스트와 유사하지만,변경 불가능하다.\n순서가 있으며 중복을 허용하고 다양한 데이터 타입을 가질 수 있다.\n튜플의 요소는 한번 정의되면 변경할 수 없다.", 18),
            new MultipleChoiceQuiz("파이썬의 다음 네가지 자료형 중, 아래의 설명과 가장 가까운 것은? \n수정 불가능(immutable)한 자료형으로, 소괄호()로 둘러싸 표현한다. \n여러개의 요소를 가질 수 있으며, 중복된 요소를 가질 수 있으나 후에 요소를 추가하거나 삭제할 수 없다.",
                Arrays.asList("리스트(list)", "세트(set)", "튜플(tuple)", "딕셔너리(dictionary)"), "튜플(tuple)", 3, "위의 설명에 해당하는 자료형은 튜플(tuple)이다.", 19),
            new MultipleChoiceQuiz("다음 코드의 출력 값은? \ndef test(a,b):\n\treturn int(a/b)\nprint(test(1,2))\n",              
                Arrays.asList("0", "0.5", "1", "오류발생"), "0", 3,  "함수 test는 a/b를 연산한 후 정수형으로 변환하여 반환한다. 따라서 test(1,2)는 int(0.5)값을 반환하므로 정수 0이 반환된다."
                , 20),
            new MultipleChoiceQuiz("딕셔너리의 특징에 대해서 옳지 않은 것은?",
                Arrays.asList("딕셔너리에서 key는 고유한 값이다.", "del 함수를 이용해서 key에 해당하는 {Key : Value}쌍을 삭제할 수 있다.", "딕셔너리에서 key는 중복으로 존재할 수 있다.", "딕셔너리의 key의 value를 얻기 위해서는 딕셔너리변수이름[key]를 사용해야 한다."), "딕셔너리에서 key는 중복으로 존재할 수 있다.", 3, "딕셔너리에서 key는 고유한 값입니다.\n따라서 중복으로 존재할 수 없습니다.", 21),
            new MultipleChoiceQuiz("x = 3.141592653이라는 실수형 변수를 소수점에 맞춰 출력하고 싶을 때 어떻게 써야하는가?",
                Arrays.asList("print(“%.4f” % x)", "print(“%.4d” % x)", "print(“%.4s” % x)", "print(“%.4x” % x)"), "print(“%.4f” % x)", 3, "실수형 변수를 소수점까지 출력하고 싶다면 \n%를 이용하여 변수를 출력할 수 있습니다. \n%s는 문자열에 대한 자리 표시자이며 %d는 정수에 대한 자리 표시자입니다. \n소수점 이하의 자리를 포함하여 출력을 하고 싶다면\n '%.자릿수f' % 숫자 를 이용해야합니다.", 
                22),
            new MultipleChoiceQuiz("다음 중 파이썬에서 함수 정의가 올바르게 된 것은 무엇입니까?",
                Arrays.asList("def my_function:", "function my_function():", "def my_function()", "def my_function():"), "def my_function():", 3, "파이썬에서 함수를 정의할 때는 'def'키워드를 사용하며 함수 이름 뒤에 괄호()와 콜론을: 붙인다.\n괄호 안에는 매개변수를 정의할 수 있으며,\n함수의 본문은 들여쓰기로 작성한다.", 
                23),
            new MultipleChoiceQuiz("다음 코드의 출력 결과는 무엇 입니까?\n for i in range(3):\n print(i*2)",
                Arrays.asList("0 1 2", "0 2 4", "1 2 3", "2 4 6"), "0 2 4", 3, "'range(3)'은 0,1,2의 숫자를 생성한다.\n 각각에 대해 'i*2'를 계산하면 0,2,4가 된다.\n 따라서 출력결과는 0,2,4 이다", 24)
                ));
                // Example quizzes for difficulty level 4
        quizPool.put(4, Arrays.asList(
            new ShortAnswerQuiz("파이썬에서 주석(comments)을 작성할 때 사용하는 기호는 무엇인가?", "#", 4, "파이썬에서 주석은 '#'기호로 시작하며, \n주석 뒤의 모든 텍스트는 실행되지 않는다.", 25),
            new ShortAnswerQuiz("리스트 numbers에서 최대값을 변수 max_num에 저장하는 한 줄의 코드를 작성하세요.", "max_num=max(numbers)", 4,"'max()' 함수는 리스트나 다른 반복 가능한 객체에서 가장 큰 요소를 반환한다.\n리스트 numbers의 최대값을 구하고 이를 변수 max_num에 저장할 수 있다.", 26),
            new ShortAnswerQuiz("다음 프로그램은 리스트의 모든 원소를 더하여 반환하는 list_sum함수이다. 괄호 속에 올바르게 함수를 정의해 보시오.\n\n(       )\n    sum1 = 0\n    for  item in mylist :\nsum1 += item\nreturn sum1\n", "def list_sum(mylist):", 4, "파이썬 함수정의 규칙은 다음과 같다.\ndef 함수이름(매개변수):\n실행문", 27),
            new ShortAnswerQuiz("for문을 이용하여 오늘의 메뉴를 출력하라.\nlist = [\"김밥\", \"라면\", \"튀김\"] \nfor 메뉴 in (  ): \nprint(\"오늘의 메뉴: \" + list)\n", "list", 4, "for문은 횟수가 있는 반복문입니다. for문을 만난 프로그램은 우선 in 키워드가 가리키는 문자열,\n튜플 또는 리스트의 요소들을 꺼내 변수에 대입합니다.", 28),
            new ShortAnswerQuiz("리스트에 주식 종목 이름이 저장되어 있다. 각 단어의 문자열의 길이를 출력하기 위해서는 print에 어떻게 써야하는가?\n리스트 = [\"SK하이닉스\", \"삼성전자\", \"LG전자\"]\nfor 종목명 in 리스트: \nprint(     )\n", "len(종목명)", 4, "문자열 길이를 출력하기 위해서는 len() 함수를 이용할 수 있습니다.\nfor문을 통해 리스트의 요소들을 꺼내 반복하고 있으므로 \nlen(종목명)이라고 작성해야합니다.", 29),
            new ShortAnswerQuiz("1에서 100까지 홀수 값들의 합을 구하는 프로그램을 작성하려 한다. 괄호에 들어갈 정수는?\n\nsum = 0\ncount = 1\nwhile count <= 100:\n     sum =  sum + count\n     count = count +  (         )\n", "2", 4,"홀수의 합을 구하는 프로그램이므로, \n변수 count를 루프를 한 번 돌 때 1부터 2씩 증가시키면 홀수 값만을 가지게 된다.\n이를 변수 sum에 누적시킨다."
            , 30),
            new ShortAnswerQuiz("다음 코드는 리스트 'numbers'의\n모든 요소를 더하여 'total'에 저장하는 코드이다.\n 빈칸에 알맞은 연산자를 써넣으시오.\nnumbers=[1,2,3,4,5]\ntotal=0\nfor number in numbers\ntotal (   ) number", "+=", 4, "'+='연산자는 더하고 할당하기 연산자이다. 이는 'total=total+number'와 동일하다", 31),
            new ShortAnswerQuiz("다음 코드는 함수'multiply'를\n정의하고 두 숫자를 곱한 결과를 반환하는 코드이다.\n빈칸에 알맞은 코드를 작성하시오.\n(   ) multiply(a,b):\n  return a*b \nresult=multiply(3,4)\nprint(result)", "def", 4,"함수는 'def'키워드를 사용하여 정의한다.", 32)
        
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

