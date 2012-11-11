import math

class Balle():
    def __init__(self, departX, departY, finX, finY, force):
        self.x = departX
        self.y = departY
        self.force = force
        self.radius = 5
        self.velocite = 15
        self.entreDeux = math.sqrt(abs((finX-departX)**2)+abs((finY-departY)**2))
        self.veloX = ((self.velocite * (finX - departX))/self.entreDeux)
        self.veloY = ((self.velocite * (finY - departY))/self.entreDeux)
        
        print("X : " + str(finX-departX))
        print("Y : " + str(finY-departY))
        print("Entre deux : " + str(self.entreDeux))
        print("veloX : " + str(self.veloX))
        print("veloY : " + str(self.veloY))
                
        '''tempX = departX + ((self.velocite/(self.entreDeux))*(finX-departX))
        tempY = departY + ((self.velocite/(self.entreDeux))*(finY-departY))
        self.veloX = ((self.velocite * (tempX - departX))/self.entreDeux)
        self.veloY = ((self.velocite * (tempY - departY))/self.entreDeux)'''
        
    def bouge(self):
        self.x += self.veloX
        self.y += self.veloY
        
    def collision(self, listePersonnage):
        for i in listePersonnage:
            rectPerso = i.obtenirLimite()
            rectBalle = self.obtenirLimite()
            j=0
            while j < 4:
                if rectBalle[j] > rectPerso[0] and rectBalle[j] < rectPerso[2]:
                    k=1
                    while k < 4:
                        if rectBalle[k] > rectPerso[1] and rectBalle[k] < rectPerso[3]:
                            i.touche(self.force)
                            return True
                        k+=2
                j+=2
                
        return False
        
    def obtenirLimite(self):
        return [self.x, self.y, self.x+self.radius, self.y+self.radius]
    