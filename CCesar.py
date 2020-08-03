# Se utiliza upper por las mayusculas

texto = input("Ingrese mensaje > ").upper()

# Cantidad de desplazamientos
n = int (input("Número que se va a desplazar > "))

# Abecedario para el cifrado
abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

# Variable del cifrado
cifrado = ""

# Método para cifrado
for l in texto:
    if l in abc:
        pos_letra = abc.index(l)
        # Suma para moverce en el abecedario
        nueva_pos = (pos_letra + n) % len(abc)
        cifrado += abc[nueva_pos]
    else:
        cifrado += l

print("El mensaje cifrado es: ", cifrado)

# DESIFRADO

texto = input("Ingrese mensaje cifrado > ").upper()

abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

# Iteracion para los valores de desplazamiento
for i in range(26):
    descifrado = ""
    for Z in texto:
        if Z in abc:
            pos_letra = abc.index(Z)
            # Resta para moverse a la izquierda
            nueva_pos = (pos_letra - i) % len(abc)
            descifrado += abc[nueva_pos]
        else:
            descifrado += Z
    msj = (f"ROT-{i}:", descifrado)
    print(msj)