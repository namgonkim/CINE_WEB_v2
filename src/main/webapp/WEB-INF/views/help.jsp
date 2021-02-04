<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="_csrf" content="${_csrf.token}" />
<title>CINE LAB - ${title}</title>
<%@include file="fragments/head.jsp"%>
</head>

<body>

	<%@include file="fragments/header.jsp"%>

	<div class="container">
		<!-- Modal -->
		<div class="" id="myModal" role="dialog">
			<div class="">

				<!-- Modal content-->
				<div class="content">
					<div class="header" style="padding: 35px 50px;">
						<h4>
							<span class="glyphicon glyphicon-lock"></span> 비밀번호 찾기
						</h4>
					</div>
					<div class="body" style="padding: 40px 50px;">
						<div style="color: #ac2925">
							<center>입력된 정보로 임시 비밀번호가 전송됩니다.</center>
						</div>
						<hr>
						<form role="form" class="form" method="post">

							<div class="form-group">
								<label for="userEmail"><span class="glyphicon glyphicon-user"></span>email</label>
								<input type="text" class="form-control" name="userEmail" id="userEmail" placeholder="가입시 등록한 이메일을 입력하세요.">
							</div>
							<button type="button" class="btn btn-success btn-block" id="checkEmail">OK</button>
						</form>
						<hr>
						<div class="text-center small mt-2" id="checkMsg" style="color: red"></div>
					</div>
					<div class="footer">
						<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Cancel
						</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    
    $('.modal').on('hidden.bs.modal', function (e) {
        console.log('modal close');
        $(this).find('form')[0].reset()
    });

    $("#checkEmail").click(function () {
        let userEmail = $("#userEmail").val();
        if(userEmail == ""){
        	alert("입력값이 없습니다");
        	return false;
        }

        $.ajax({
            type: "GET",
            url: "/check/findPw",
            data: {
                "userEmail": userEmail,
            },
            beforeSend: function(xhr){
			xhr.setRequestHeader(header, token);	// 헤드의 csrf meta태그를 읽어 CSRF 토큰 함께 전송
			},
            success: function (res) {
                if (res['check']) {
                	alert("입력하신 이메일로 임시비밀번호가 발송됩니다");
                	$.ajax({
                		type: "GET",
                		url: "/help/sendEmail",
                		data: { "userEmail" : userEmail, },
                		beforeSend: function(xhr){
						xhr.setRequestHeader(header, token);	// 헤드의 csrf meta태그를 읽어 CSRF 토큰 함께 전송
						},
                		success: function(res) {
                			if(res['check']) {
                				alert("발송을 완료하였습니다.");
                				location.href="/user/login";
                			}
                		},
                		error: function (xhr) { console.log(xhr.responseText); },
                	})
                    $('#checkMsg').html('<p style="color:darkblue">이메일을 확인하고 다시 로그인해주세요</p>');
                }
                else {
                    $('#checkMsg').html('<p style="color:red">일치하는 정보가 없습니다.</p>');
                }
            }
        })
    })
</script>
</html>