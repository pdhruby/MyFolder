package programmer.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 
구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아
  return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
 * 
 * 
 * 입출력 예) 
    array	                       commands	                  return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */
public class KNumber {
	public static void main(String[] args) {
		
	int[] array = {1,5,2,6,3,7,4};
	int[][] commands = new int[][]{{2,5,3},{4,4,1},{1,7,3}};
	
	solution(array,commands);
		
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer =new int[commands.length];
        int i =0;
        int j =0;
        int s=0;
        int a=0;
        int k=0;
    
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        
        for(i =0 ; i < commands.length; i++) {
        	for(j=0; j<commands[i].length;j++) {
        	 arrayList.add(commands[i][j]);
        	}
        }
        for(i=0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i)+" ");
        }
        	System.out.println();

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for(s=0; s<commands.length; s++) {
        	i = arrayList.get(s*3); 
        	j = arrayList.get(s*3+1);
        	k = arrayList.get(s*3+2);
        	System.out.println("기준 : " + i + " " + j + " " + k + " ");
        	for(a = i-1; a<j; a++) {
        		arrayList2.add(array[a]);
        		System.out.println(arrayList2);
        	}
        	Collections.sort(arrayList2);
        	System.out.println("정렬된것 확인" + arrayList2);
        	System.out.println("몇번쨰인지" + k);
        	answer[s] = arrayList2.get(k-1);
        	arrayList2.clear();
        }    
        return answer;
        }
 }