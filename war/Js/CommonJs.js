$(document)
		.ready(
				function() {
					$.post("BlogDetails", function(result) {
						$("#blogdetails").html(result);
						$(".bloglink").click(BlogContentFunc);

						function BlogContentFunc() {
							// var username = $("#bloglink").val();
							var username = $(this).attr('value');
							var title = $(this).attr('id');
							console.log(username)
							console.log(title)
							var url = "FechBlogContent?username=" + username
									+ "&title=" + title;

							$.get(url, function(result) {
								$("#test").html(result);

								console.log(result);

							});

						}

					});

					$("#blogformbtn").click(function() {
						$("#blogform").toggle();

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
					$("#blogcreatebtn").click(blogFunc);

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

						$.post("BlogCreation", {
							"title" : title,
							"heading" : heading,
							"discription" : discription

						}, function(result) {

							$("#blogdetails").hide();
							history.go(0);
							// "location.reload()",
							// "history.go(0)",
							// "location.href = location.href",
							// "these are the methods to refresh a page"
							// "location.href = location.pathname",
							// "location.replace(location.pathname)",
							// "location.reload(false)"

						});

					}

					function signInfunc() {
						var username = document.getElementById('username').value;
						var password = document.getElementById('password').value;

						$.post("Login", {
							"username" : username,
							"password" : password,

						}, function(result, status) {

							if (result == "true") {

								window.location.href = "Index.jsp";

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
								window.location.href = "Index.jsp";
								if (!alert('Thank you for Registration')) {

									return false;

								}

							}
							$("#submitpara").html(result);

						});

					}
				});
