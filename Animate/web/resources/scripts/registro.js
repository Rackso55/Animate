/*Funcion que verifica si una cadena cumple con alguna expresion regular*/
  jQuery.validator.addMethod("test_cadena", function(value, element,param) {  
    var expR = new RegExp(param);
    return this.optional( element ) || expR.test( value );
  }, "Campos invalidos");

function validaRegistro(){
    $("#form_registro").validate({        
        success: function(label) {
            label.addClass("valido").text('Correcto!');            
        },
        rules: { 
            nombre_usuario: {                 
                required: true,
                test_cadena: "^[0-9a-zA-Z]+$"
            },

            edad: { 
                required: true,
                number: true,
                range: [8,12]
                //test_cadena: "^[0-9]+$"          
            },
            
            grado: {
                required: true
            }, 
            
            nickname: {
                required: true,
                test_cadena: "^[0-9a-zA-Z]+$"
            },
            
            password: {
                required: true,
                test_cadena: "^[0-9a-zA-Z]+$"
            },
            
            confirm: {
                required: true,
                test_cadena: "^[0-9a-zA-Z]+$",
                equalTo: "#password"
            }

        },

        messages:{
            nombre_usuario: { 
                required: "Campo obligatorio"
            },            
            edad: { 
                required: "Campo obligatorio",
                number:"Solo acepta números",
                range: "Edad entre 8 y 12"
            },
            
            grado: {
                required: "Campo obligatorio"
            },
            
            nickname: { 
                required: "Campo obligatorio"                
            },
            password: { 
                required: "Campo obligatorio"          			
            },
            confirm: { 
                required: "Campo obligatorio"          			 ,
                equalTo: "Confirmación incorrecta"
            }
        }
		       
    });   
}