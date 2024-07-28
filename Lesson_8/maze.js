$(document).ready(function () {
  $("#boundary1").mouseover(function () {
    alert("You just moved your mouse over the #boundary1 element!");
    $(this).addClass("youlose");
  });
  $("#boundary1").mouseleave(function () {
    $(this).removeClass("youlose");
  });

  let gameLost = false;
  $(".boundary").mouseover(function () {
    $(this).addClass("youlose");
    gameLost = true;
  });
  //   $(".boundary").mouseleave(function () {
  //     $(this).removeClass("youlose");
  //   });

  $("#end").mouseover(function () {
    if (!gameLost) {
      //   alert("You win! :]");
      $("#status").text("You win! :]");
    } else {
      //   alert("Sorry, you lost. :]");
      $("#status").text("Sorry, you lost. :]");
    }
  });

  $("#start").click(function () {
    gameLost = false;
    $(".boundary").removeClass("youlose");
    $("#maze").mouseleave(function () {
      $(".boundary").addClass("youlose");
      gameLost = true;
      $("#status").text("Sorry, you lost. :]");
    });
  });
});
