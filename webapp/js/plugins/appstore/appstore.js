    (function($) {
        $.fn.uniformHeight = function() {
            var maxHeight = 0,
                    max = Math.max;

            return this.each(function() {
                maxHeight = max(maxHeight, $(this).height() + 30);
            }).height(maxHeight);
        }
    })(jQuery);

    $(".thumbnails").find(".thumbnail").uniformHeight();
