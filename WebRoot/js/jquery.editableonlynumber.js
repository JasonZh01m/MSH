// jQuery.editable.js v1.1.1
// http://shokai.github.io/jQuery.editable
// (c) 2012-2013 Sho Hashimoto <hashimoto@shokai.org>
// The MIT License
(function($){
  var escape_html = function(str){
    return str.replace(/</gm, '&lt;').replace(/>/gm, '&gt;');
  };
  var unescape_html = function(str){
    return str.replace(/&lt;/gm, '<').replace(/&gt;/gm, '>');
  };

  $.fn.editable = function(event, callback){
    if(typeof callback !== 'function') callback = function(){};
    if(typeof event === 'string'){
      var trigger = this;
      var action = event;
      var type = 'input';
    }
    else if(typeof event === 'object'){
      var trigger = event.trigger || this;
      if(typeof trigger === 'string') trigger = $(trigger);
      var action = event.action || 'click';
      var type = event.type || 'input';
    }
    else{
      throw('Argument Error - jQuery.editable("click", function(){ ~~ })');
    }

    var target = this;
    var edit = {};

    edit.start = function(e){
      trigger.unbind(action === 'clickhold' ? 'mousedown' : action);
      if(trigger !== target) trigger.hide();
      var old_value = (
        type === 'textarea' ?
          target.html().replace(/<br( \/)?>/gm, '\n').replace(/&gt;/gm, '>').replace(/&lt;/gm, '<') :
          target.text()
      ).replace(/^\s+/,'').replace(/\s+$/,'');

      var input = type === 'textarea' ? $('<textarea>') : $('<input>');
      input.attr("class", "form-control");
      
      // 限制输入框输入的内容
      input.keyup(function(){
          $(this).val($(this).val().replace(/[^0-9.-]/g,''));  
      }).bind("paste",function(){  //CTR+V事件处理  
          $(this).val($(this).val().replace(/[^0-9.-]/g,''));   
      }).css("ime-mode", "disabled"); //CSS设置输入法不可用
      
      
      input.val(old_value).
        /*css('width', type === 'textarea' ? '100%' : target.width()+target.height() ).*/
      	css('width', '100%').
      	css('height', '100%').
      	/*css('border-color', '100%').*/
        css('font-size','100%').
        css('padding', 0).
        css('margin',0).attr('id','editable_'+(new Date()*1)).
        addClass('editable');
      if(type === 'textarea') input.css('height', target.height());

      var finish = function(){
        var result = input.val().replace(/^\s+/,'').replace(/\s+$/,'');
        var html = escape_html(result);
        if(type === 'textarea') html = html.replace(/[\r\n]/gm, '<br />');
        target.html(html);
        callback({value : result, target : target, old_value : old_value});
        edit.register();
        if(trigger !== target) trigger.show();
       /* alert("Finish");*/
        
        //重新计算总计部分
        modalInit();
        
      };

      input.blur(finish);
      if(type === 'input'){
        input.keydown(function(e){
          if(e.keyCode === 13) finish();
        });
      }

      target.html(input);
      input.focus();
    };

    edit.register = function(){
      if(action === 'clickhold'){
        var tid = null;
        trigger.bind('mousedown', function(e){
          tid = setTimeout(function(){
            edit.start(e);
          }, 500);
        });
        trigger.bind('mouseup mouseout', function(e){
          clearTimeout(tid);
        });
      }
      else{
        trigger.bind(action, edit.start);
      }
    };
    edit.register();

    return this;
  };
})(jQuery);
