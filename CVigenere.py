import string

#Ingreso de la llave
mykey=input("Introducir Clave: ")
mykey=mykey.replace(" ", "")
mykey=mykey.upper()

# Se usa ascii para cambiar las letras por sus valores númericos
source = string.ascii_uppercase

# El ABC normal se esta moviendo una posición a la izquierda
shift = 1
matrix = [source[(i + shift) % 26] for i in range(len(source))]

# INICIO DEL MÉTODO DE CIFRADO
def coder():
    input_text = str(input("Ingrese un mensaje:"))
    input_text = input_text.upper()
    ciphertext = []
    control = 0

    for x, i in enumerate(input_text.upper()):
        if i not in source:
            ciphertext.append(i)
            continue
        else:
            control = 0 if control % len(mykey) == 0 else control

            # Calcular la posición de la letra en el string
            result = (source.find(i) + matrix.index(mykey[control])) % 26
            ciphertext.append(matrix[result])
            control += 1

    print(ciphertext)
    code_text=ciphertext

# INICIO DEL MÉTODO DE DESCIFRAR
def decoder():
    input_text = str(input("Introduce Mensaje:"))
    input_text = input_text.upper()
    control = 0
    plaintext = []

    for x, i in enumerate(input_text.upper()):
        if i not in source:
            plaintext.append(i)
            continue
        else:
            control = 0 if control % len(mykey) == 0 else control

            # Calcular la posición de la letra en el string
            result = (matrix.index(i) - matrix.index(mykey[control])) % 26
            plaintext.append(source[result])
            control += 1

    print(plaintext)


while(1):
    print("\nPresione el número de la opción que quiera realizar")
    opcion=int(input("1.Cifrar \n2.Descifrar: \n3.Salir \n"))
    if opcion==1:
        coder()
    elif opcion==2:
        decoder()
    elif opcion==3:
        exit()
    else:
        print("Ingrese un número valido ")