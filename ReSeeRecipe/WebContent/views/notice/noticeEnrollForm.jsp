<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int loginMemberNo = (int)(request.getAttribute("loginMemberNo"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성하기</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<!-- 해시태그 Tagify 라이브러리 -->
	<!-- 소스 다운 -->
	<script src="https://unpkg.com/@yaireo/tagify"></script>
	<!-- 폴리필 (구버젼 브라우저 지원) -->
	<script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
	<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />

<style>

    .custom-file{
        width : 30%;
    }

    #HL_noticeContent{
        width : 500px;
        height : 200px;
        resize: none;
    }

    #HL_noticeTitle, #HL_noticeWriter, #HL_noticeHashtag{
        width : 500px;
    }
    /* button[type=submit]{
        align : "center";
    } */
    #HL_noticeContent {
        resize : none;
    }

</style>
</head>
<body>
    <%@ include file="../manager/navbar.jsp" %>
<div class="rs-content">
    <br><br>
    <h2>공지사항 작성</h2>
    <br><br>
    <div class="container">
        <form enctype="multipart/form-data" class="form" action="<%=contextPath%>/hlnoticeEnroll.ma" id="HL_noticeEnroll_Form" method="post">
            
            <!-- Session의 loginMember에서 관리자 정보 hidden으로 넘겨서 notice테이블에 insert -->
            <input type="hidden" name="adminNo" value=<%=loginMemberNo%>>
            <label for="HL_noticeTitle">공지사항 제목 : </label>
            <input type="text" class="form-control" placeholder="제목을 입력하세요" name="HL_noticeTitle" id="HL_noticeTitle" required>
    <!--    <label for="HL_noticeWriter">작성자 :</label>  -->   
    <!--    <input type="password" class="form-control" placeholder="관리자 | 매니저" name="HL_noticeWriter" id="HL_noticeWriter" required> -->      
            <br>
            <label for="HL_noticeFile">이미지</label> <br>
            <div class="custom-file">
                <input type="file" name="HL_noticeFile" id="HL_noticeFile">
            </div>  
            <br><br>
            <label for="HL_noticeContent">공지사항 내용</label>
            <textarea class="form-control" rows="5" name="HL_noticeContent" id="HL_noticeContent"></textarea>
            <br>
           
    <!--   <label for="HL_noticeHashtag">해시태그</label>
            <input type="text" class="form-control" placeholder="해시태그를 입력하세요(#제외)" name="HL_noticeHashtag" id="HL_noticeHashtag">
            <br> --> 
            <lable for="HL_noticeTag">해시태그</lable> <br>
            <input id="HL_noticeTag" name='tags'
  			class='some_class_name'            
 			placeholder='해시태그를 입력해주세요'      
  			data-blacklist='ㅅㅂ, ㄲㅈ, 죽어, 디저, ㅂㅅ, 시발'
  			>  
                  
			<script>
			$(document).ready(function () {
			    // 서버에서 whitelist 데이터를 받아옵니다.
			    $.ajax({
			      url: 'hlhashtag.tg',
			      type: 'GET',
			      dataType: 'json',
			      success: function (result) {
			        // 결과가 객체 배열일 때 "tagName" 필드를 추출하여 whitelist로 설정
			        var whitelist = result.map(function (item) {
			          return item.tagName;
			        });
			        initTagify(whitelist);
			        
			      },
			      error: function (error) {
			        console.error('에러 발생:', error);
			      }
			    });

			    function initTagify(whitelist) {
			      var inputElm = document.querySelector('input[name=tags]');

			      var tagify = new Tagify(inputElm, {
			        enforceWhitelist: true,
			        whitelist: whitelist,
			        dropdown: {
			          maxItems: 5,
			          enabled: 0,
			          closeOnSelect: true,
			        }
			      });

			      tagify.on('input', onInput);

			      function onInput(e) {
			        var value = e.detail.value;
			        var input = value.toLowerCase().trim();
			        var dataBlacklist = inputElm.getAttribute('data-blacklist');
			        var blacklist = dataBlacklist.split(',').map(function (item) {
			          return item.trim().toLowerCase();
			        });

			        if (blacklist.includes(input)) {
			          //tagify.removeTags();
			          console.log('입력값이 블랙리스트에 포함되어 삭제됨.');
			          tagify.replaceTag();
			        }
			      }

			      tagify.on('add', onAddTag);
			      
			      function onAddTag(e) {
					var dataInput = e.detail.data.value;
			        var hashtagList = [];
			        console.log(tagify.value);
			        console.log(tagify.value.length);
			        
			        for(let i=0 ; i< tagify.value.length ; i++){
			        	hashtagList.push(tagify.value[i].value);
			        }
			        console.log(hashtagList);
			      }
			      
			    }
			    
			  });
			
			</script>
            
            <br><br>
            <button type="submit" class="btn btn-warning">등록하기</button>
            <button type="submit" class="btn btn-warning">목록으로</button>
        </form>
    </div>
</div>
</body>
</html>