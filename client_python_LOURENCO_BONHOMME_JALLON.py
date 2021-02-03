from zeep import Client
client = Client("http://localhost:8989/?wsdl")
result = client.service.affichage(2)
print("Le résultat renvoyé par le service est", result)

result2 = client.service.afficherProduits()
print("Le résultat renvoyé par le service est", result2)

result3 = client.service.methodeSomme(2,3)
print("Le résultat renvoyé par le service est", result3)

