/*Funcion que verifica si una cadena cumple con alguna expresion regular*/
  jQuery.validator.addMethod("test_cadena", function(value, element,param) {  
    var expR = new RegExp(param);
    return this.optional( element ) || expR.test( value );
  }, "Campos invalidos");

function validaDatos(){
    $("#form_sesion").validate({
        success: function(label) {
            label.addClass("valido1").text('Correcto!');            
        },
        rules: { 
            username: { 
                required: true,
                test_cadena: "^[0-9a-zA-Z]+$"
            },

            password: { 
                required: true,
                test_cadena: "^[0-9a-zA-Z<>!@#$%&(-,|]+$"          
            }

        },

        messages:{
            username: { 
                required: "Campo obligatorio"          			 
            },

            password: { 
                required: "Campo obligatorio"          			
            }
        }		       
    });   
}