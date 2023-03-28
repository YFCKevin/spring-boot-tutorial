const loc = location.origin;
const email = $("input#email");
const password = $("input#password");

$("button.trip_comfirm_btn").on("click", function () {
  $.ajax({
    url: `${loc}/proj.member-yifan/member/login`,
    type: "POST",
    data: JSON.stringify({
      email: email.val(),
      password: password.val(),
    }),
    statusCode: {
      200: function (res) {
        console.log(res);
        alert("成功");
      },
      400: function (res) {
        console.log(res);
      },
    },
    error: function (xhr) {
      console.log("error");
    },
  });
});
