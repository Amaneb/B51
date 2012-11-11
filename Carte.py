class Carte():
    def __init__(self):
        self.nomMap = "F_E1S1"
        self.s = Salle()
        self.s.chargeCarte(self.nomMap)
        self.chargeObjets()
		
    def chargeObjets(self):	
        liens = open("liens/liens.txt", 'r')
        ligne = list()
        ligne = liens.read()

        """Tous les objets possible"""
        self.listeObjet = ["Logomate", "Sac", "Coffre", "Test"]

        """Liste des positions de chaque objet """
        self.listeLogo = list()
        self.listeSac = list()
        self.listeCoffre = list()
        self.listeTest = list()
        
        self.mapValide = False
        self.valideAssign = False
        self.validePlaceFichier = False
        self.posListeObj = 0
        
        for i in ligne.splitlines():
            i.split('\n')
            if(i == self.nomMap):
                print ("CHARGEMENT OBJETS DE LA MAP: " + self.nomMap)
                for j in ligne.splitlines():
                    if(j == self.nomMap):
                        self.mapValide = True
                        self.valideEmplacement = True
                    if(j == self.listeObjet[self.posListeObj] and self.mapValide == True):
                        print("CHARGEMENT OBJETS: " + self.listeObjet[self.posListeObj])
                        self.valideAssign = True
                        self.mapValide = False
                    elif(self.valideAssign == True and j != "break"):
                        if(self.listeObjet[self.posListeObj] == "Logomate"):
                            self.listeLogo.append(j)
                        elif (self.listeObjet[self.posListeObj] == "Sac"):
                            self.listeSac.append(j)
                        elif(self.listeObjet[self.posListeObj] == "Coffre"):
                            self.listeCoffre.append(j)
                        elif(self.listeObjet[self.posListeObj] == "Test"):
                            self.listeTest.append(j)
                    elif(self.valideAssign == True and j == "break"):
                        self.valideAssign = False
                        self.mapValide = True
                        self.posListeObj += 1
                        if(self.posListeObj >= len(self.listeObjet)):
                            self.posListeObj -= 1
                    if(j == ";" and self.validePlaceFichier == True):
                        break
                break

        """Pour afficher les positions (test seulement)"""
        print (self.listeLogo)
        print (self.listeSac)
        print (self.listeCoffre)
        print (self.listeTest)
            

class Salle():
    def __init__(self):
        self.salle = list()
    
    def chargeCarte(self, nomMap):
        f = open("Map/" + nomMap + ".mp", 'r')
        self.salle = list()
        
        f.readline()
        f.readline()
        f.readline()
        ligne = list()
        ligne = f.read()
        
        for i in ligne.splitlines():
            i.split('\n')
            self.salle.append(i)

#if __name__=="__main__":
    #Carte()
