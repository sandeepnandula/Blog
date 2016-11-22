$(document)
		.ready(
				function() {

					$("#userlogin").click(function() {
						window.location.href = "Login.html";
					});
					$("#Login").click(signInfunc);

					$("#usersignup").click(function() {
						window.location.href = "Signup.html";

					});
					$("#submit").click(signUpFunc);

					$("#Logout").click(function() {
						$.post({
							url : 'Logout',
							success : function(result) {
								$("body").html(result);

							}
						})
					});

					function signInfunc() {
						var username = document.getElementById('username').value;
						var password = document.getElementById('password').value;
						var url = "Login?username=" + username + "&password="
								+ password;

						$
								.post({
									url : url,
									success : function(result, status) {

										if (result == "true") {

											window.location.href = "welcome.jsp";
											if (!alert('You are sucessfully loged in')) {

												return false;
											}
											window.location.href = "welcome.jsp";
										}

										$(".para").html(result);
									}
								});
					}

					function signUpFunc() {
						var username1 = document
								.getElementById('signupusername').value;
						var password1 = document
								.getElementById('signuppassword').value;
						var emailId1 = document.getElementById('signupemailId').value;

						var url = "Signup?username1=" + username1
								+ "&password1=" + password1 + "&emailId1="
								+ emailId1;

						$.post({
							url : url,
							success : function(result) {

								if (result == "true") {
									window.location.href = "welcome.jsp";
									if (!alert('Thank you for Registration')) {

										return false;

									}

								}
								$("#submitpara").html(result);

							}
						});

					}
				});
