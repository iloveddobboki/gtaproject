SoftwareEngineeringProject
==========================
같이 작업하게될 공간입니다. 우리는 Eclipse랑 Github플러그인을 쓸겁니다.

(중간중간안되는걸발견했습니다!)

# Prepare
0. JDK가 있는지 확인부터 해봅시다.
  `시작 - 실행 - cmd - "java -version"` 을 하면 `java version "1.7.0_51"` 과 비슷하게 나와야합니다. (1.8이면 안되요!)
1. JDK가 없다면 받자구요. http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
2. 안드용 Eclipse(ADT)도 받구요. (있으면 스킵) http://developer.android.com/sdk/index.html
3. 받아서 압축을 풀고 SDK Manager.exe를 실행시켜 Android SDK를 업데이트합시다. (오른쪽아래에 버튼이있습니다. + 약관동의)
4. Eclipse에 GITHUB플러그인을 받아야합니다. 압축 푼 ADT폴더 안에 eclipse/eclipse.exe가 있습니다. 실행!
5. 맨 위에 `Help - Install New Software`를 클릭.
6. Work With:창에 http://download.eclipse.org/egit/github/updates 를 적고 엔터를 치면.
7. 밑에 Collaboration이 뜹니다. 저걸 체크해서 설치하고 Eclipse를 껏다 켭니다.

# Code Download
0. Eclipse에서 `File - Import - Git - Projects from Git`를 누르고
1. 검색창에 SogangSoftwareEngineeringProject 를 칩니다.
2. minhoryang/SogangSoftwareEngineeringProject를 선택합니다.
3. Next를 눌러야합니다. (Next버튼이 안뜨면 `Projects from Git`이 아니라 `Repositories from Github`를 누른거니 뒤로가서 다시해주세요.
4. master가 보이면 Next를 눌러주세요.
5. 디렉토리를 자기 workspace안으로 넣어주세요. (C:\Users\R912COM\workspace4\SogangSoftwareEngineeringProject)
6. 다음을 누르고 Import existing projects가 체크되어있는것을 확인하고 또 다음을 누릅니다.
7. SSEP와 SSEPDB에 체크되어있는것을 확인한 후 Finish를 누릅니다.
8. Eclipse왼편의 Package Explorer에 SSEP와 SSEPDB가 보일것입니다.

# Change Upload
0. 무언가를 편집했습니다. 이를 모든 팀원이 보게 올리고싶습니다.
1. 해당 프로젝트(SSEP나 SSEPDB)를 우클릭하여 `Team - Fetch from Upstream`을 통해 우선 서버의 코드를 받아옵니다.
2. 위의 과정에서 문제가 생길 수 있습니다. (Conflict, 다른사람과 작업이 겹쳤습니다. 민호를 찾아주세요.)
3. 문제가 없다면 코드를 올립시다!
4. 해당 프로젝트(SSEP나 SSEPDB)를 우클릭하여 `Team - Commit`을 누릅니다.
5. 새 창이 뜨면서 아래에 수정된 파일 목록이 뜹니다. 하나씩 더블클릭해서 변경사항을 확인해봅시다.
6. 원하는 변경사항이 포함된 파일만 왼쪽에 클릭해서 서버에 올릴준비를 합니다.
7. 위의 Commit Message칸에 "자신이 무엇을 했는지"를 씁시다.
8. 아래에 Commit and Push버튼이 생겼습니다.
9. ID와 PW를 적어야하는데 Github 회원가입할때의 정보를 적으면 서버에 올라갑니다.
10. 카톡으로 팀원에게 이 기쁜소식을 알립니다.
