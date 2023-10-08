<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.semi.board.recipe.model.vo.RecipeCategory" %>    
<%
	ArrayList<RecipeCategory> list = (ArrayList<RecipeCategory>)request.getAttribute("list");
	String successMsg = (String)session.getAttribute("successMsg");
	String failMsg = (String)session.getAttribute("failMsg");
%>            
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[메뉴관리] 카테고리 관리</title>


<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />

<style>
.sort {
	display: inline-block;
	padding-left: 10px;
	color: darkgray;
}
.table th:hover {
	cursor: pointer;
}
.asc::before {
	content: "\25B2";
}
.desc::before {
	content: "\25BC";
}
.modal .modal-title{
	text-align: center;
	font-weight: bold;
}
.modal .modal-content{
	background-color: rgb(255, 217, 64);
    padding: 5px 20px 30px 20px;
}
.modal .modal-body, .modal .modal-footer{
	background-color: white;
	padding:0;
}
.modal .modal-footer{
	height: 50px;
	border: 1px solid gray;
	justify-content: center;
}
.modal-table {
	width:100%;
	text-align: center;
}
.modal-table th {
	width: 130px;
}
.modal-table tr {
	height: 40px;
}
.modal input {
    width: 100%;
    height: 50px;
    cursor: pointer;
    border: none;
}
.searchTable{
	padding: 0 10px;
}
</style>

<!-- sweetalert -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />

</head>
<body>

	<%@ include file="../../manager/navbar.jsp" %>
	
    <div class="rs-content">        
        <div class="header">
            <div class="h-title p-3">   <!-- 패딩 1rem -->
                [메뉴 관리] 카테고리 관리
            </div>
            <div class="searchTable">
            	<table>
            		<tr>
            			<td><input type="text" placeholder="검색할 카테고리명을 입력하세요" size="30"><button type="submit">조회</button></td>
            		</tr>
            	</table>
            </div>
            <div class="h-content d-flex p-3">  <!-- 패딩 1rem -->
                <div class="mr-auto">
                    조회수 <span class="waiting"><%= list.size() %></span><span>개</span>
                </div>
                <div >
                    <button onclick="showAddCategorydModal()" class="btn btn-sm btn-warning">카테고리 추가</button>
                    <button class="btn btn-sm btn-warning">카테고리 수정</button>
                    <button onclick="deleteCategory()" class="btn btn-sm btn-secondary">카테고리 삭제</button>
                </div>
            </div>
        </div>
        <div class="tableBody">
            <table id='tb-category' class="table table-sm table-hover">
                <thead>
                    <tr>
                        <th data-idx=0><input type="checkbox"></th>
                        <th data-idx=1 data-type="num">번호<div class="sort"></div></th>
                        <th data-idx=2>카테고리명<div class="sort"></div></th>
                        <th data-idx=3>게시글 수<div class="sort"></div></th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list == null || list.isEmpty()) { %>
   	                <tr>
	                    <td colspan="4">등록한 카테고리가 없습니다</td>
	                </tr>
                    <% } else { %>
                    	<% for(RecipeCategory recipeCategory : list) { %>
	                    <tr>
	                        <td><input type="checkbox"></td>
	                        <td><%= recipeCategory.getRecipeCategoryNo() %></td>
	                        <td><%= recipeCategory.getRecipeCategoryName() %></td>
	                        <td><%= recipeCategory.getRecipeCategoryCount() %></td>
	                    </tr>	
	                    <% } %>
					<% } %>    
                </tbody>
            </table>	<!-- tb-category -->
        </div>	<!-- tableBody  -->
   	</div>  <!-- rs-content -->
   	
	<!-- 카테고리 추가  modal창 -->
 	<div class="modal" id="addCategoryForm">
		<form method="get" action="<%= contextPath %>/jhinsert.ct">
	        <div class="modal-dialog">
	            <div class="modal-content">
	                <!-- Modal Header -->
	                <div class="modal-header">
	                    <h4 class="modal-title">카테고리 추가</h4>
	                    <button type="button" class="close" data-dismiss="modal">&times;</button>	<!-- x 닫기버튼 -->
	                </div> 
	                <!-- Modal body -->
	                <div class="modal-body">
							<input type="hidden" name="dmNo">
							<table class="modal-table" border="1">
								<tr>
									<th>카테고리명</th>
									<td>
										<input type="text" name="recipeCategoryName">
									</td>
									<td><button onclick="" class="btn btn-sm btn-warning btn-serach">중복확인</button></td>
								</tr>
							</table>
	                </div>
	                <!-- Modal footer -->
	                <div class="modal-footer">
	             		<button type="submit" class="btn btn-sm btn-warning">추가</button>
	                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">취소</button>
	                </div>
	            </div>
	        </div>
	</form>
  </div>	<!-- 카테고리 추가 modal -->
  
  <!-- 카테고리 추가 modal -->
  <script>
  		function showAddCategorydModal(){
  			$('#addCategoryForm').modal('show');
  		}	// showAddCategorydModal
  </script> 	
   	
  	<!-- alertMsg script -->
  <script>
		var successMsg = '<%= successMsg %>';
		var failMsg = '<%= failMsg %>';
		
		if(successMsg != 'null'){
			swal('성공', successMsg, 'success');	// alert대신 swal 라이브러리 사용
		}
		
		if(failMsg != 'null'){
			swal('실패', failMsg, 'error');
		}
		
		<% session.removeAttribute("successMsg"); %>
		<% session.removeAttribute("failMsg"); %>
  </script>
  
  <!-- 카테고리 삭제  -->
  <script>
  		function deleteCategory(){
  			
  			// 모든 table의 tr요소
  			let trs = document.querySelectorAll('.table tr');
  			// console.log(trs);
  			
  			let checked_tr = null;
  			for(let tr of trs){
  				let input = tr.children[0].children[0];
  				if(input.checked){
  					checked_tr = tr;
  					// console.log(checked_tr);
  					break;
  				}
  			}
  			
  			if(checked_tr == null){
  				swal('실패', '카테고리를 선택해주세요!', 'error');
  				return;
  			}
  			
			$(function() {
				swal({
					title: "카테고리를 삭제하시겠습니까?",
					text : "※ 삭제 후 복원이 불가합니다",
					type: "warning",
					showCancelButton: true,
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "삭제",
					cancelButtonText: "취소",
				}, function (isConfirm) {
					if (!isConfirm) return;
					
					let table = document.getElementById('tb-category');
					let trs = table.querySelectorAll('tr');
					
					let category_list = [];
					
					for(let tr of trs){
						let input = tr.children[0].children[0];
						if(input.checked == true){
							category_list.push(tr.children[1].textContent);	
						}
					}
					
		 			$.ajax({
		 				url : 'jhdelete.ct',
						type : 'get',
						data : {'categoryNo' : category_list},
						success : function(result) {
							//  성공인 경우 [배열로 받음]
							console.log('성공');
							for(let tr of trs){
								let categoryNo = parseInt(tr.children[1].textContent);
								if(result.includes(categoryNo)){
									tr.remove();
								}
							}
						},	// success
						error : function(result){
							console.log('실패');
						}	// error
					});
		 			
				});
			});
  		};
  </script>	
   	
   	

</body>
</html>