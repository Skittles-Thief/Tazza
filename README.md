# Tazza
간단하게 구현한 섯다 게임입니다.<br>
네트워크를 통한 플레이가 아닌, 싱글 플레이를 전제로 만들어진 게임입니다.

##개발환경
윈도우 10, eclipse, jdk 1.8.0

## 사용법
#### 로그인창
* 로그인 창에서는 원하는 프로필이미지/닉네임/소지금을 설정할 수 있습니다.
* 닉네임은 랜덤버튼을 누르거나 아무것도 입력하지 않을 경우 임의의 닉네임을 설정합니다.
#### 판돈 선택창
* 판돈 선택창에서는 게임팁 버튼을 눌러 게임 방법을 볼 수 있고, 원하는 판돈의 방을 선택하여 입장 할 수 있습니다.
* back버튼을 누를경우, 로그인창으로 돌아갑니다.
#### 게임창
* 시작버튼을 누를경우 패를 돌리고 게임을 시작합니다.
* 게임 중에는 방바꾸기/재시작/종료를 할 수 없습니다.
* 플레이어는 6개의 배팅옵션중 하나를 선택 할 수있습니다.
* 첫번째 판은 플레이어의 선으로 시작하며, 이후 이긴 플레이어가 선을 잡습니다.
* 3회의 배팅이 끝나면 살아있는 사람들 중 패를 비교하여 승자를 가립니다.
* 모든 돈을 잃을경우 시작버튼을 누르면 게임오버 메시지와 함께 로그인창으로 이동됩니다.

## 참고
* 작업의 처리 도중, 버튼을 누를 경우 문제가 발생할 수 있습니다.
* 올인을 하게 될 경우, 어떤 배팅옵션을 누르던 콜을 수행합니다.
* 올인 혹은 다이를 하게 되었을 경우 배팅 버튼을 눌러주셔야 컴퓨터의 배팅이 진행됩니다.

## 제작자
본 프로그램 박민규, 오세민, 차민재, 최영진의 팀 프로젝트입니다.
