$(document)
		.ready(
				function() {

					$.post({
						url : 'BlogDetails',
						success : function(result) {
							$("#blogdetails").html(result);
							$(".bloglink").click(
									function() {
										// var username = $("#bloglink").val();
										var username = $(this).attr('value');
										var title = $(this).attr('id');
										console.log(username)
										console.log(title)
										var url = "FechBlogDetails?username="
												+ username + "&title=" + title;
										$.post({
											url : url,
											success : function(result) {

											}
										})

									});
						}
					});

					$("#blogform").click(function() {
						$("#blogdetails").toggle();

					});
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
					$("#blogbtn").click(blogFunc);

					function blogFunc() {
						var title = document.getElementById('blogtitle').value; // var
						// title
						// =
						// $("#blogtitle").value();
						var heading = document.getElementById('blogheading').value;
						var discription = document
								.getElementById('blogdiscription').value;

	
						console.log(title)
						console.log(heading)
						console.log(discription)
						console.log(datetime)
						var url = "BlogCreating?title=" + title + "&heading="
								+ heading + "&discription=" + discription
						"&datetime=" + datetime;
						$.ajax({
							url : url,
							success : function(result) {
								console.log("done")
								history.go(0);
								// "location.reload()",
								// "history.go(0)",
								// "location.href = location.href",
								// "these are the methods to refresh a page"
								// "location.href = location.pathname",
								// "location.replace(location.pathname)",
								// "location.reload(false)"
								$("#blogdetails").hide();
							}
						});
						// $.post("BlogDetails", {
						// title : title,
						// heading : heading,
						// discription : discription
						// }, function(result) {
						// console.log("sucess")
						// });
					}

					function signInfunc() {
						var username = document.getElementById('username').value;
						var password = document.getElementById('password').value;

						$.post("Login", {
							"username" : username,
							"password" : password,

						}, function(result, status) {

							if (result == "true") {

								window.location.href = "welcome.jsp";
								// if (!alert('You are sucessfully loged
								// in')) {
								//
								// return false;
								// }
								// window.location.href = "welcome.jsp";
							}

							$(".para").html(result);
						});
					}

					function signUpFunc() {
						var username1 = document
								.getElementById('signupusername').value;
						var password1 = document
								.getElementById('signuppassword').value;
						var emailId1 = document.getElementById('signupemailId').value;

						$.post("Signup", {
							"username1" : username1,
							"password1" : password1,
							"emailId1" : emailId1
						}, function(result) {

							if (result == "true") {
								window.location.href = "welcome.jsp";
								if (!alert('Thank you for Registration')) {

									return false;

								}

							}
							$("#submitpara").html(result);

						});

					}
				});
