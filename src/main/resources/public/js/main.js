jQuery(function ($) {

  $("form").submit(function (evt) {
    evt.preventDefault();
    var $form = $(this);

    $form.hide();

    var xhr = $.ajax({
      url: $form.attr('action'),
      method: $form.attr('method'),
      data: $form.serialize()
    });

    xhr.done(function (data) {
      $form.html('<h4>Message Sent!</h4>');
      $form.show();
    });


  });
});