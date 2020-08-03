
# Función para cifrar y descifrar
def atbash(intext):

# alfabetos a utilizar
# Los alfabetos a utilizar se estan intercambiando el sentido la A ahora será la Z, la B la Y y así con las demás letras

    inputAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    atbashAlpha = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba9876543210"
    output = ""

    for z in intext:
        if z in inputAlpha:
            # Función para hacer hacer cambio del abecedario y ver cuales son las posiciones de las letras y cambiarlas
            output += atbashAlpha[inputAlpha.index(z)]
        else:
            output += z

    return output


# ------ Consola ------
print("------ CIFRADO DE ATBASH ------")
print("------ Alexandra Zuleica Gadar Delgado 8999 ------\n")

text = input("Ingrese el texto para cifrar o descifrar: ")
print(atbash(text))

# Use esta forma para hacer el código porque se me hizo la manera más sencilla para el desarrollo del código
# Y como le mencione en por mensaje, soy nueva en Python y no quería