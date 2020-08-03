from re import findall

# Pregunta para comenzar
print("--------- Código de Playfair ---------\n")
print("Elige una opción, después de elegir la opción presionar el botón ENTER")
inicio = input("[E]ncriptar |[D]esencriptar: ").upper()

if inicio not in ['E', 'D']:
    print("Error: porfavor escribir una de las opciones");
    raise SystemExit

advertencia = list(input("La KEY de este código es LZARD"))
message = list(input("Escribe un mensaje: ").upper())
matrixKey = [
    ['L', 'I', 'Z', 'A', 'R'],
    ['D', 'B', 'C', 'E', 'F'],
    ['G', 'H', 'K', 'M', 'N'],
    ['O', 'P', 'Q', 'S', 'T'],
    ['U', 'V', 'W', 'X', 'Y']
];

# Si se llegara a encontrar una palabra impar a la ultima leta se le agregara una X
for l in matrixKey:
    print(l)
addSymbol = 'X'

# MÉTODO PARA TOMAR LAS PALABRAS POR PARES
def regular(text):
    template = r"[A-Z]{2}"
    return findall(template, text)

# MÉTODO PARA ENCRIPTAR Y DESENCRIPTAR EL MENSAJE
def encryptDecrypt(cryptMode, message, final=""):
    if cryptMode == 'E':
        for symbol in message:
            if symbol not in [chr(x) for x in range(65, 91)]:
                message.remove(symbol)

    # ESTE SIRVE PARA DETERMINAR SI EN LA PALABRA QUE SE INGRESA HAY UNA J LA REMPLAZAERÁ POR UNA I
        for index in range(len(message)):
            if message[index] == 'J':
                message[index] = 'I'
        for index in range(1, len(message)):
            if message[index] == message[index - 1]:
                message.insert(index, addSymbol)
        if len(message) % 2 != 0:
            message.append(addSymbol)

# COMIENZA HACER LA LISTA DE LOS PARES DE PALABRAS
    binaryList = regular("".join(message))
    for binary in range(len(binaryList)):
        binaryList[binary] = list(binaryList[binary])
        for indexString in range(len(matrixKey)):
            for indexSymbol in range(len(matrixKey[indexString])):
                if binaryList[binary][0] == matrixKey[indexString][indexSymbol]:
                    y0, x0 = indexString, indexSymbol
                if binaryList[binary][1] == matrixKey[indexString][indexSymbol]:
                    y1, x1 = indexString, indexSymbol
        for indexString in range(len(matrixKey)):
            if matrixKey[y0][x0] in matrixKey[indexString] and matrixKey[y1][x1] in matrixKey[indexString]:
                if cryptMode == 'E':
                    x1 = x1 + 1 if x1 != 4 else 0
                    x0 = x0 + 1 if x0 != 4 else 0

                else:
                    x1 = x1 - 1 if x1 != 0 else 4
                    x0 = x0 - 1 if x0 != 0 else 4

            y0, y1 = y1, y0

            binaryList[binary][0] = matrixKey[y0][x0]
            binaryList[binary][1] = matrixKey[y1][x1]
    for binary in range(len(binaryList)):
        for symbol in binaryList[binary]:
            final += symbol
    return final

# Impresión del resultado
print("Resultado:", encryptDecrypt(inicio, message))