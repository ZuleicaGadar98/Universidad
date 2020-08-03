
import math

#Ingreso de la llave
mykey=input("NOTA: Su palabra clave NO puede repetir letras \nIntroducir Clave:")
mykey=mykey.upper()


def encryptMessage(msg):
    cipher = ""

    k_indx = 0

    msg_len = float(len(msg))
    msg_lst = list(msg)
    key_lst = sorted(list(mykey))

    # Número de columnas de la matriz
    col = len(mykey)

    # Número de filas de la matriz
    row = int(math.ceil(msg_len / col))

    # Llenado de lugares vacios en la matriz
    fill = int((row * col) - msg_len)
    msg_lst.extend('X' * fill)

    # Creación de la matriz
    matrix = [msg_lst[i: i + col]
              for i in range(0, len(msg_lst), col)]

    for _ in range(col):
        curr_idx = mykey.index(key_lst[k_indx])
        cipher += ''.join([row[curr_idx]
                           for row in matrix])
        k_indx += 1

    return cipher

def decryptMessage(cipher):
    msg = ""

    # Indices de la llave
    k_indx = 0

    msg_indx = 0
    msg_len = float(len(cipher))
    msg_lst = list(cipher)

    # Número de columnas
    col = len(mykey)

    # Filas de la matriz
    row = int(math.ceil(msg_len / col))

    # Ordena la llave de manera alfabeticamente
    key_lst = sorted(list(mykey))

    # crea la matriz para desencriptar
    dec_cipher = []
    for _ in range(row):
        dec_cipher += [[None] * col]

    # Acomoda las columnas de acuerdo al orden de la llave 
    for _ in range(col):
        curr_idx = mykey.index(key_lst[k_indx])

        for j in range(row):
            dec_cipher[j][curr_idx] = msg_lst[msg_indx]
            msg_indx += 1
        k_indx += 1

    # Conversión a string
    try:
        msg = ''.join(sum(dec_cipher, []))
    except TypeError:
        raise TypeError("This program cannot",
                        "handle repeating words.")

    null_count = msg.count('_')

    if null_count > 0:
        return msg[: -null_count]

    return msg

msg = str(input("Ingrese un mensaje:"))
msg = msg.upper()

cipher = encryptMessage(msg)
print("Mensaje encriptado: {}".
      format(cipher))

print("Mensaje desencriptado: {}".
      format(decryptMessage(cipher)))