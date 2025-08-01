# [Silver I] 너의 이름은 - 14653 

[문제 링크](https://www.acmicpc.net/problem/14653) 

### 성능 요약

메모리: 14008 KB, 시간: 88 ms

### 분류

구현, 애드 혹

### 제출 일자

2025년 7월 20일 13:40:39

### 문제 설명

<p>OAKAK TALK에는 신기한 기능이 있다. 바로 메시지 옆에 아직 안 읽은 사람의 수를 표시해주는 기능이다. 하지만 이 기능은 읽지 않은 사람의 수만 표시해줄 뿐, 메시지를 읽지 않은 사람이 누구인지는 표시해주지 않는다. 따라서 이 기능으로 메시지를 몇 명이 읽었는지는 알 수 있지만, 누가 읽었는지는 알 수 없다. 하지만 특정한 조건을 만족한다면, 우리는 메시지를 읽지 않은 사람을 유추해낼 수 있다.</p>

<p>그 조건은 다음과 같다. N명이 있는 OAKAK TALK방이 있다. 그리고 그 방에는 K개의 메시지가 있다. 각각의 메시지는 해당 메시지의 송신자와 읽지 않은 사람의 수에 대한 정보를 담고 있다. 만약 어떤 시점에 메시지를 읽거나 보냈다면, 그 시점 이전에 수신된 메시지는 모두 읽은 것으로 처리된다.</p>

<p>Q번째 메시지를 읽지 않은 사람을 유추 가능한대로 모두 구해보자! 사람의 이름은 편의상 A, B, C, …, Z라고 하며, N명의 이름은 A부터 사전 순서대로 N개의 알파벳이 부여된다. “나”의 이름은 A이고 “나”는 항상 모든 메시지를 읽는다.</p>

### 입력 

 <p>첫째 줄에 OAKAK TALK방에 있는 사람 수 N과 총 메시지의 개수 K, 정보를 알고 싶은 메시지의 번호 Q가 주어진다. (1 ≤ N ≤ 26, 1 ≤ K ≤ 10,000, 1 ≤ Q ≤ K) 둘째 줄부터 K개의 줄에 걸쳐 메시지를 읽지 않은 사람의 수 R과 그 메시지 송신자의 이름 P가 하나의 공백을 사이에 두고 주어진다. 메시지를 읽지 않은 사람의 수는 항상 이전 메시지를 읽지 않은 사람의 수보다 크거나 같고, 모순되는 입력은 없음이 보장된다.</p>

### 출력 

 <p>메시지를 읽지 않았을 가능성이 있는 모든 사람의 이름을 사전 순서대로 하나의 공백을 사이에 두고 출력한다. 모든 사람이 메시지를 읽어 출력할 이름이 없는 경우에는 –1을 출력한다.</p>

